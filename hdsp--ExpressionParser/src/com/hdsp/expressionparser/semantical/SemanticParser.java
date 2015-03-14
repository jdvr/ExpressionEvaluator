package com.hdsp.expressionparser.semantical;

import java.util.HashMap;
import java.util.List;
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

    private HashMap<TokenType, Integer> preferences() {
        return new HashMap<TokenType, Integer>() {{
            put(PlusSign, 2);
            put(SubSign, 2);
            put(MultiplySign, 3);
        }};
    }

    public Expression buildEvaluableExpression(List<Token> tokens) {

        for (Token token : tokens) {
            switch (token.getType()) {
                case IntegerConstant:
                    leftStack.push(new Constant((Integer) token.getValue()));
                    break;
                case FloatConstant:
                    leftStack.push(new Constant((Float) token.getValue()));
                    break;
                case DoubleConstant:
                    leftStack.push(new Constant((Double) token.getValue()));
                    break;
                case LeftParenthesis:
                    downStack.push(token.getType());
                    break;
                case RightParenthesis:
                    TokenType popped;
                    while (!downStack.isEmpty()) {
                        popped = downStack.pop();
                        if (popped == LeftParenthesis) {
                            break;
                        } else {
                            addNode(popped);
                        }
                    }
                    break;
                default:
                    while (!downStack.isEmpty() && tokenHasLessPreferenceThanDownPeek(token)) {
                        downStack.pop();
                        addNode(token.getType());
                    }
                    downStack.push(token.getType());
                    break;
            }
        }
        while (!downStack.isEmpty()) {
            addNode(downStack.pop());
        }
        return leftStack.pop();
    }

    private boolean tokenHasLessPreferenceThanDownPeek(Token token) {
        return token.getType().getPreference() < downStack.peek().getPreference();
    }


    private void addNode(TokenType operator) {
        Expression rightExpression = leftStack.pop();
        Expression leftExpression = leftStack.pop();
        if (operator == PlusSign) {
            leftStack.push(new Add(leftExpression, rightExpression));
        } else if (operator == MultiplySign) {
            leftStack.push(new Multiply(leftExpression, rightExpression));
        } else if (operator == SubSign) {
            leftStack.push(new Sub(leftExpression, rightExpression));
        }

    }
}
