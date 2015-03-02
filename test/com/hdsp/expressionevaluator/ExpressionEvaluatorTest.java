package com.hdsp.expressionevaluator;

import com.hdsp.expressionevaluator.expressions.Addition;
import com.hdsp.expressionevaluator.expressions.Constant;
import com.hdsp.expressionevaluator.model.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ExpressionEvaluatorTest {

    @Test
    public void withOneElement() throws Exception {
        Expression expression = new Constant(5);
        Interpreter interpreter = new Interpreter();
        assertEquals(5,interpreter.evaluate(expression));
    }

    @Test
    public void withOtherElement() throws Exception {
        Expression expression = new Constant(8);
        Interpreter interpreter = new Interpreter();
        assertEquals(8,interpreter.evaluate(expression));
    }

    @Test
    public void withSimpleIntegerIntegerAddition() throws Exception {
        Expression expression = new Addition(new Constant(8), new Constant(9));
        Interpreter interpreter = new Interpreter();
        assertEquals(17,interpreter.evaluate(expression));
    }

    @Test
    public void withSimpleFloatIntegerAddition() throws Exception{
        Expression expression = new Addition(new Constant(8.5f), new Constant(9));
        Interpreter interpreter = new Interpreter();
        assertEquals(17.5f,interpreter.evaluate(expression));
    }


}
