package com.hdsp.expressionparser.semantical;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionparser.lexical.Token;
import com.hdsp.expressionparser.lexical.TokenType;

public class ExpressionBuilder {
    public static Expression buildOperation(TokenType operator, Expression left, Expression right) {
        return OperatorBuilder.getBuilderFor(operator).build(left, right);
    }

    public static Expression buildConstant(Token token) {
        return  ConstantBuilder.getBuilderFor(token.getType()).build(token.getValue());
    }
}
