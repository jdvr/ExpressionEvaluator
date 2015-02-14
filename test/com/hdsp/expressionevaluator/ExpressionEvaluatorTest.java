package com.hdsp.expressionevaluator;

import org.junit.Test;

import com.hdsp.expressionevaluator.model.Add;
import com.hdsp.expressionevaluator.model.Expression;
import com.hdsp.expressionevaluator.model.Value;

import static org.junit.Assert.*;

public class ExpressionEvaluatorTest {
    
    @Test
    public void withOneValue() throws Exception{
        Expression expression = new Value(9);
        assertEquals(9, new ExpressionEvaluator(expression).evaluate());
    }

    @Test
    public void withTwoValueOneOperation() throws Exception{
        Expression expression = new Add(new Value(8), new Value(8));
        assertEquals(16, new ExpressionEvaluator(expression).evaluate());
    }

    @Test
    public void withThreeValuesTwoOperations() throws Exception{
        Expression expression = new Add(new Value(8), new Add(new Value(8), new Value(8)));
        assertEquals(24, new ExpressionEvaluator(expression).evaluate());
    }

}
