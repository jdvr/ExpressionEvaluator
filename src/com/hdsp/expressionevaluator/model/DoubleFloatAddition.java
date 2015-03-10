package com.hdsp.expressionevaluator.model;

public class DoubleFloatAddition extends BinaryOperation {

    public DoubleFloatAddition(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Double) getLeft() + (Float) getRight();
    }

    @Override
    public String type() {
        return "Double";
    }
}
