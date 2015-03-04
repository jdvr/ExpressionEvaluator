package com.hdsp.expressionevaluator.model;

import com.hdsp.expressionevaluator.Evaluable;

public abstract class BinaryOperation implements Evaluable{
    protected final Object left;
    protected final Object right;

    public BinaryOperation(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    public Object getLeft() {
        return left;
    }

    public Object getRight() {
        return right;
    }
}
