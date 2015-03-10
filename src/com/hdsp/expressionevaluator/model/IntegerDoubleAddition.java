package com.hdsp.expressionevaluator.model;

public class IntegerDoubleAddition extends BinaryOperation {

    public IntegerDoubleAddition(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Integer) getLeft() + (Double) getRight();
    }

    @Override
    public String type() {
        return "Double";
    }
}
