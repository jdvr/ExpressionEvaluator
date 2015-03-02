package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.model.Evaluable;
import com.hdsp.expressionevaluator.model.Expression;

public class Constant implements Expression, Evaluable {
    private Object value;

    public Constant(Integer value) {
        this.value = value;
    }

    public Constant(Float value) {
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
}
