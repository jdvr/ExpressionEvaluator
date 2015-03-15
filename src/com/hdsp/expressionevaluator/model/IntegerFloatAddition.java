package com.hdsp.expressionevaluator.model;

public class IntegerFloatAddition extends BinaryOperation {

    public IntegerFloatAddition(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Integer) getLeft() + (Float) getRight();
    }

    @Override
    public String type() {
        return "Float";
    }
}
