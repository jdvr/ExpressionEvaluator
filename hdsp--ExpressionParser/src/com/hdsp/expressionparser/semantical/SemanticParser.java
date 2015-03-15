package com.hdsp.expressionparser.semantical;

import java.util.Arrays;
import java.util.Stack;

import com.hdsp.expressionevaluator.Expression;
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

    public Expression parser(Token... tokens) throws SemanticParserException {
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
                processDownStackPushing(token);
                continue;
            }
            leftStack.push(ExpressionBuilder.buildConstant(token));
        }

        buildExpressionWithDownStackOperatorsAndLeftStackToken();

        return builtExpression();
    }

    private Expression builtExpression() {
        return leftStack.pop();
    }

    private void buildExpressionWithDownStackOperatorsAndLeftStackToken() {
        while (!downStack.isEmpty())
            addNode(downStack.pop());
    }

    private void processDownStackPushing(Token token) {
        while (!downStack.isEmpty() && tokenHasLessPreferenceThanDownPeek(token)) {
            downStack.pop();
            addNode(token.getType());
        }
        downStack.push(token.getType());
    }

    private boolean checkWellFormedExpression(Token[] tokens) {
        return checkNotTwoConstantOrOperatorsConsecutive(tokens) && checkParenthesisPairs(tokens);
    }

    private boolean checkParenthesisPairs(Token[] tokens) {
        return countLeftParenthesis(tokens) == countRightParenthesis(tokens);
    }

    private int countRightParenthesis(Token[] tokens) {
        return countSymbol(RightParenthesis, tokens);
    }

    private int countSymbol(TokenType symbolType, Token[] tokens) {
        return (int) Arrays.asList(tokens).stream()
                                    .filter(token -> token.getType() == symbolType)
                                    .count();
    }

    private int countLeftParenthesis(Token[] tokens) {
        return countSymbol(LeftParenthesis, tokens);
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
        leftStack.push(ExpressionBuilder.buildOperation(operator, leftExpression, rightExpression));
    }

}
