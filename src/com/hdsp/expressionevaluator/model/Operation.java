package com.hdsp.expressionevaluator.model;

public abstract class Operation implements Expression{

    protected final Expression leftExpression;
    protected final Expression rightExpression;

    public Operation(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;

    }

    @Override
    public abstract int calculate();
}
