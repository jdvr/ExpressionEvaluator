package com.hdsp.expressionevaluator.expressions;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;

/**
 * Created by JuanDavid on 25/02/2015.
 */
public abstract class Operator implements Evaluable, Expression {

    protected String typeOf(Object operand){
        return operand.getClass().getSimpleName();
    }

    protected Object evaluateOperand(Expression expression) {
        return isEvaluable(expression) ? evaluable(expression).value() : nullEvaluable();
    }

    private Evaluable evaluable(Expression expression){
        return (Evaluable) expression;
    }

    private boolean isEvaluable(Expression expression){
        return expression instanceof Evaluable;
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
