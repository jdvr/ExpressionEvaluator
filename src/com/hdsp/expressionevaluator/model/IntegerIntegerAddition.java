package com.hdsp.expressionevaluator.model;

public class IntegerIntegerAddition extends Addition{

    private final Expression leftExpression;
    private final Expression rightExpression;

    public IntegerIntegerAddition(Expression leftExpression, Expression rightExpression)  {
        super(leftExpression, rightExpression);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Object evaluate() {
        return (Integer) leftExpression.evaluate() + (Integer) rightExpression.evaluate();
    }

    @Override
    public Class getType() {
        return Integer.class;
    }
}
