package com.hdsp.expressionevaluator.model;

public class FloatIntegerSubtraction extends BinaryOperation {

    public FloatIntegerSubtraction(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Float) getLeft() - (Integer) getRight();
    }

    @Override
    public String type() {
        return "Float";
    }
}
