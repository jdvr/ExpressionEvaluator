package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Expression;

public class Sub extends BinaryOperator {

    public Sub(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return evaluate("Subtraction");
    }

    @Override
    public String type() {
        return typeOf(value());
    }
}
