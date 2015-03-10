package com.hdsp.expressionevaluator.model;

public class FloatFloatAddition extends BinaryOperation {

    public FloatFloatAddition(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Float) getLeft() + (Float) getRight();
    }

    @Override
    public String type() {
        return "Float";
    }
}
