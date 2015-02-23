package com.hdsp.expressionevaluator;

import com.hdsp.expressionevaluator.model.Expression;

/**
 * Created by Javichu on 09/02/2015.
 */
public class Interpreter {
    public int evaluate(Expression expression) {
        return expression.evaluate();
    }
}
