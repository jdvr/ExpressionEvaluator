package com.hdsp.expressionevaluator;

import com.hdsp.expressionevaluator.model.Expression;

public class Interpreter {
    public Object evaluate(Expression expression) {
        return expression.evaluate();
    }
}
