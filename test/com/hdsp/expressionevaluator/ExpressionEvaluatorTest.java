package com.hdsp.expressionevaluator;

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
    public void withSimpleSum() throws Exception {
        Expression expression = new Sum(new Constant(8), new Constant(9));
        Interpreter interpreter = new Interpreter();
        assertEquals(17,interpreter.evaluate(expression));
    }

    @Test
    public void withSimpleSubtraction() throws Exception {
        Expression expression = new Subtraction(new Constant(25), new Constant(10));
        Interpreter interpreter = new Interpreter();
        assertEquals(15,interpreter.evaluate(expression));
    }

    @Test
    public void withSimpleMultiplication() throws Exception {
        Expression expression = new Multiplication(new Constant(5), new Constant(4));
        Interpreter interpreter = new Interpreter();
        assertEquals(20,interpreter.evaluate(expression));
    }

    @Test
    public void withSimpleDivision() throws Exception {
        Expression expression = new Division(new Constant(25), new Constant(5));
        Interpreter interpreter = new Interpreter();
        assertEquals(5,interpreter.evaluate(expression));
    }

    @Test
    public void RewardTest() throws Exception {
        Expression expression = new Sum(new Subtraction(new Multiplication(new Constant(5), new Constant(10)), new Division(new Constant(20), new Constant(2))), new Constant(8));
        Interpreter interpreter = new Interpreter();
        assertEquals(48,interpreter.evaluate(expression));
    }

}
