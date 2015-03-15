package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;

public class Add extends BinaryOperator {

    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object value() {
        return evaluate(Operations.Addition);
    }

    @Override
    public String type() {
        return typeOf(value());
    }

    @Override
    public boolean isEvaluable() {
        return true;
    }

    @Override
    public Evaluable getEvaluable() {
        return getEvaluable(evaluateOperand(getLeft()), evaluateOperand(getRight()), Operations.Addition);
    }
}
