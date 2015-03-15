package com.hdsp.expressionevaluator.model;

public class DoubleIntegerAddition extends BinaryOperation {

    public DoubleIntegerAddition(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Double) getLeft() + (Integer) getRight();
    }

    @Override
    public String type() {
        return "Double";
    }
}
