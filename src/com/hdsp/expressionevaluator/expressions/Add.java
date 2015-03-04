package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Expression;

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
