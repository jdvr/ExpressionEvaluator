package com.hdsp.expressionevaluator.model;

import com.hdsp.expressionevaluator.expressions.Addition;

public class FloatIntegerAddition extends Addition {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public FloatIntegerAddition(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Object evaluate() {
        return (Float) leftExpression.evaluate() + (Integer) rightExpression.evaluate();
    }

    @Override
    public Class getType() {
        return Float.class;
    }
}
