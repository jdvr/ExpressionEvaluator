package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;

public abstract class Operator implements Evaluable, Expression {

    protected String typeOf(Object expression){
        if(expression instanceof Constant) return ((Constant) expression).type();
        return expression.getClass().getSimpleName();
    }

    protected Object evaluateOperand(Expression expression) {
        return expression.isEvaluable() ? expression.getEvaluable().value() : nullEvaluable();
    }

    protected Evaluable nullEvaluable() {
        return new Evaluable() {
            @Override
            public Object value() {
                return null;
            }

            @Override
            public String type() {
                return "NaN";
            }
        };
    }
}
