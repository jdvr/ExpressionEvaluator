package com.hdsp.expressionevaluator.expressions;

import java.lang.reflect.Constructor;

import com.hdsp.expressionevaluator.model.BinaryOperation;
import com.hdsp.expressionevaluator.model.Expression;

public class Add extends BinaryOperator {

    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return evaluate("Addition");
    }

    @Override
    public String type() {
        return typeOf(value());
    }
}
