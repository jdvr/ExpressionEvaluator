package com.hdsp.expressionevaluator.model;

public class Constant implements Expression{
    private int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
