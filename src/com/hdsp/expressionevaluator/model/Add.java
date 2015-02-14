package com.hdsp.expressionevaluator.model;

/**
 * Created by JuanDavid on 14/02/2015.
 */
public class Add extends Operation{

    public Add(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int calculate() {
        return leftExpression.calculate() + rightExpression.calculate();
    }
}
