package com.hdsp.expressionevaluator.model;

public class Constant implements Expression{
    private Object value;

    public Constant(Integer value) {
        this.value = value;
    }

    public Constant(Float value) {
        this.value = value;
    }

    @Override
    public Object evaluate() {
        return value;
    }

    @Override
    public Class getType() {
        return value.getClass();
    }
}
