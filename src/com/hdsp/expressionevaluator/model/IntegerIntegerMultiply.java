package com.hdsp.expressionevaluator.model;

import com.hdsp.expressionevaluator.expressions.Multiply;

/**
 * Created by JuanDavid on 14/03/2015.
 */
public class IntegerIntegerMultiply extends BinaryOperation{

    public IntegerIntegerMultiply(Object left, Object right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return (Integer) getLeft() * (Integer) getRight();
    }

    @Override
    public String type() {
        return "Integer";
    }
}
