package com.hdsp.expressionevaluator.model;

public class FloatDoubleSubtraction extends BinaryOperation {

    public FloatDoubleSubtraction(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Float) getLeft() - (Double) getRight();
    }

    @Override
    public String type() {
        return "Double";
    }
}
