package com.hdsp.expressionevaluator;

import com.hdsp.expressionevaluator.model.Add;
import com.hdsp.expressionevaluator.model.Expression;

public class ExpressionEvaluator {
    private final Expression expression;

    public ExpressionEvaluator(Expression expression) {
        this.expression = expression;
    }

    public int evaluate() {
        return expression.calculate();
    }
}
