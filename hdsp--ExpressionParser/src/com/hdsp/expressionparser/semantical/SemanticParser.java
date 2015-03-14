package com.hdsp.expressionparser.semantical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionevaluator.expressions.Add;
import com.hdsp.expressionevaluator.expressions.Constant;
import com.hdsp.expressionevaluator.expressions.Multiply;
import com.hdsp.expressionevaluator.expressions.Sub;
import com.hdsp.expressionparser.lexical.Token;
import com.hdsp.expressionparser.lexical.TokenType;

import static com.hdsp.expressionparser.lexical.TokenType.*;

public class SemanticParser {

    private final Map<TokenType, Integer> preference;
    private Stack<TokenType> downStack;
    private Stack<Expression> leftStack;

    public SemanticParser() {
        this.preference = new HashMap<TokenType, Integer>() {{
            put(PlusSign, 2);
            put(SubSign, 2);
            put(MultiplySign, 3);
        }};
    }

    public Expression buildEvaluableExpression(List<Token> tokens) {
        downStack = new Stack<>();
        leftStack = new Stack<>();
        for(Token token : tokens) {
            switch(token.getType()) {
                case IntegerConstant:
                    leftStack.push(new Constant((Integer)token.getValue()));
                    break;
                case FloatConstant:
                    leftStack.push(new Constant((Float)token.getValue()));
                    break;
                case DoubleConstant:
                    leftStack.push(new Constant((Double)token.getValue()));
                    break;
                default:
                    Integer downStackTokenPreference;
                    while(!downStack.isEmpty() && (downStackTokenPreference = preference.get(downStack.peek())) != null) {
                        System.out.println("NO");
                        if ((preference.get(token.getType()) != downStackTokenPreference)
                                && preference.get(token.getType()) >= downStackTokenPreference)
                            break;
                            downStack.pop();
                            addNode(token.getType());
                    }
                    downStack.push(token.getType());
                    break;
            }
        }
        while(!downStack.isEmpty()) {
            addNode(downStack.pop());
        }
        return leftStack.pop();
    }


    private void addNode(TokenType operator) {
        Expression rightExpression = leftStack.pop();
        Expression leftExpression = leftStack.pop();
        if(operator == PlusSign)
            leftStack.push(new Add(leftExpression, rightExpression));
        else if (operator == MultiplySign)
            leftStack.push(new Multiply(leftExpression, rightExpression));

    }
}
