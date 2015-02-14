package com.hdsp.expressionevaluator.model;

public class Value implements Expression {
    private final int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}
