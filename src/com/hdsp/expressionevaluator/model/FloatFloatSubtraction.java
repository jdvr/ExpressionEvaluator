package com.hdsp.expressionevaluator.model;

public class FloatFloatSubtraction extends BinaryOperation {

    public FloatFloatSubtraction(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Float) getLeft() - (Float) getRight();
    }

    @Override
    public String type() {
        return "Float";
    }
}
