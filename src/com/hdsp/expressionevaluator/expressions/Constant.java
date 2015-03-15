package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;

public class Constant implements Expression, Evaluable {
    private final Object value;

    public Constant(Integer value) {
        this.value = value;
    }

    public Constant(Float value) {
        this.value = value;
    }

    public Constant(Double value) {
        this.value = value;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public String type() {
        return value.getClass().getSimpleName();
    }

    @Override
    public boolean isEvaluable() {
        return true;
    }

    @Override
    public Evaluable getEvaluable() {
        return this;
    }
}
