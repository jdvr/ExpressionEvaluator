package com.hdsp.expressionevaluator.model;

import java.lang.reflect.Constructor;

public class Addition extends BinaryOperation {
    private Expression expression;

    public Addition(Expression expression) throws Exception{
        super(leftExpression, rightExpression);
    }


    public Object evaluate() {
        return expression.evaluate();
    }

    @Override
    public Class getType() {
        return expression.getType();
    }
}
