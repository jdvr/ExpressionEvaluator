package com.hdsp.expressionevaluator.model;

/**
 * Created by Javichu on 17/02/2015.
 */
public class Multiplication extends Operation{

    public Multiplication(Expression leftExpression, Expression rightExpression) {
        super(leftExpression,rightExpression);
    }

    public int evaluate() {
        return leftExpression.evaluate() * rightExpression.evaluate();
    }
}
