package com.hdsp.expressionevaluator.expressions;

public enum Operations {
    Addition("Addition"), Subtraction("Subtraction"), Multiply("Multiply");
    private String operationName;

    Operations(String operationName) {

        this.operationName = operationName;
    }


    @Override
    public String toString() {
        return operationName;
    }
}
