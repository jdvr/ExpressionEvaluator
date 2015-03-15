package com.hdsp.expressionevaluator.model;

public class DoubleDoubleSubtraction extends BinaryOperation {

    public DoubleDoubleSubtraction(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Double) getLeft() - (Double) getRight();
    }

    @Override
    public String type() {
        return "Double";
    }
}
