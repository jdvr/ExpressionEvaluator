package com.hdsp.expressionevaluator;


public class NoEvaluableExpressionException extends Exception {


    private String expression;

    public NoEvaluableExpressionException(String expression) {

        this.expression = expression;
    }

    @Override
    public synchronized Throwable getCause() {
        return new Throwable("Cannot Evaluate Expression: " + expression);
    }
}
