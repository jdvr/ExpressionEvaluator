package com.hdsp.expressionevaluator.model;

public abstract class BinaryOperation implements Evaluable, Expression{
    protected Expression leftExpression;
    protected Expression rightExpression;

    public BinaryOperation(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public abstract Object evaluate();

}
