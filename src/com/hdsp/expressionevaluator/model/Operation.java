package com.hdsp.expressionevaluator.model;

public abstract class Operation implements Expression{
    protected Expression leftExpression;
    protected Expression rightExpression;

    public Operation(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public abstract int evaluate();

}
