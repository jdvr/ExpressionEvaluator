package com.hdsp.expressionparser.semantical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionevaluator.expressions.Add;
import com.hdsp.expressionevaluator.expressions.Constant;
import com.hdsp.expressionevaluator.expressions.Multiply;
import com.hdsp.expressionevaluator.expressions.Sub;
import com.hdsp.expressionparser.lexical.Token;
import com.hdsp.expressionparser.lexical.TokenType;

import static com.hdsp.expressionparser.lexical.TokenType.*;

public class SemanticParser {

    private Stack<TokenType> downStack;
    private Stack<Expression> leftStack;

    public SemanticParser() {
        downStack = new Stack<>();
        leftStack = new Stack<>();
    }

    public Expression buildEvaluableExpression(Token... tokens) throws SemanticParserException {
        if (! checkWellFormedExpression(tokens)) throw  new SemanticParserException("Wrong Formed Expression");
        for (Token token : tokens) {

            if (token.getType() == LeftParenthesis) {
                downStack.push(token.getType());
                continue;
            }

            if (token.getType() == RightParenthesis) {
                resolvesParenthesis();
                continue;
            }

            if (token.getType() == PlusSign || token.getType() == MultiplySign || token.getType() == SubSign) {
                while (!downStack.isEmpty() && tokenHasLessPreferenceThanDownPeek(token)) {
                    downStack.pop();
                    addNode(token.getType());
                }
                downStack.push(token.getType());
                continue;
            }

            leftStack.push(ExpressionBuilder.build(token));
        }

        while (!downStack.isEmpty())
            addNode(downStack.pop());

        return leftStack.pop();
    }

    private boolean checkWellFormedExpression(Token[] tokens) {
        return checkNotTwoConstantOrOperatorsConsecutive(tokens) && checkParenthesisPairs(tokens);
    }

    private boolean checkParenthesisPairs(Token[] tokens) {
        int pairCounted = 0;
        for (Token token : tokens) {
            if (token.getType() == LeftParenthesis) pairCounted++;
            if (token.getType() == RightParenthesis) pairCounted--;
        }
        return pairCounted == 0;
    }

    private boolean checkNotTwoConstantOrOperatorsConsecutive(Token[] tokens) {
        for (int i = 1; i < tokens.length - 1; i++) {
            if (tokens[i].getType() == LeftParenthesis || tokens[i].getType() == RightParenthesis) continue;
            if (tokens[i - 1].getType() == tokens[i].getType()) return false;
            if (tokens[i].getType() == tokens[i + 1].getType()) return false;
        }
        return true;
    }

    private void resolvesParenthesis() {
        TokenType popped;
        while (!downStack.isEmpty()) {
            popped = downStack.pop();
            if (popped == LeftParenthesis) {
                break;
            }
            addNode(popped);
        }
    }

    private boolean tokenHasLessPreferenceThanDownPeek(Token token) {
        return token.getType().getPreference() < downStack.peek().getPreference();
    }


    private void addNode(TokenType operator) {
        Expression rightExpression = leftStack.pop();
        Expression leftExpression = leftStack.pop();
        leftStack.push(ExpressionBuilder.build(operator, leftExpression, rightExpression));
    }

    private static class ExpressionBuilder {
        public static Expression build(TokenType operator, Expression left, Expression right) {
            return OperatorBuilder.getBuilderFor(operator).build(left, right);
        }

        public static Expression build(Token token) {
            return  ConstantBuilder.getBuilderFor(token.getType()).build(token.getValue());
        }
    }

    private static class OperatorBuilder {
        private static Map<TokenType, OperationBuilder> operationBuilder = buildOperatorsMap();

        private static Map<TokenType, OperationBuilder> buildOperatorsMap() {
            return new HashMap<TokenType, OperationBuilder>() {{
                put(PlusSign, Add::new);
                put(SubSign, Sub::new);
                put(MultiplySign, Multiply::new);
            }};
        }

        public static OperationBuilder getBuilderFor(TokenType operator) {
            return operationBuilder.get(operator);
        }

        @FunctionalInterface
        private interface OperationBuilder {
            public Expression build(Expression left, Expression right);
        }
    }

    private static class ConstantBuilder {
        private static Map<TokenType, ValueBuilder> valueBuilder = buildOperatorsMap();

        private static Map<TokenType, ValueBuilder> buildOperatorsMap() {
            return new HashMap<TokenType, ValueBuilder>() {{
                put(IntegerConstant, value -> new Constant((Integer) value));
                put(FloatConstant, value -> new Constant((Float) value));
                put(DoubleConstant, value -> new Constant((Double) value));
            }};
        }

        public static ValueBuilder getBuilderFor(TokenType constant) {
            return valueBuilder.get(constant);
        }

        @FunctionalInterface
        private interface ValueBuilder {
            public Expression build(Object value);
        }
    }
}
