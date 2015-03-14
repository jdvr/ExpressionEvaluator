package com.hdsp.expressionevaluator;


import com.hdsp.expressionevaluator.expressions.Add;
import com.hdsp.expressionevaluator.expressions.Constant;
import com.hdsp.expressionevaluator.expressions.Multiply;
import com.hdsp.expressionevaluator.expressions.Sub;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ExpressionEvaluatorTest {

    @Test
    public void withIntegerConstant() throws Exception {
        Evaluable evaluable = new Constant(5);
        assertEquals(5,evaluable.value());
        assertEquals(Integer.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withIntegerAddition() throws Exception {
        Evaluable evaluable = new Add(new Constant(3), new Constant(5));
        assertEquals(8, evaluable.value());
        assertEquals(Integer.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withFloatIntegerAddition() throws Exception {
        Evaluable evaluable = new Add(new Constant(5.0f), new Constant(3));
        assertEquals(8.0f, evaluable.value());
        assertEquals(Float.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withIntegerFloatAddition() throws Exception {
        Evaluable evaluable = new Add(new Constant(4) , new Constant(5.0f));
        assertEquals(9.0f, evaluable.value());
        assertEquals(Float.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withFloatAddition() throws Exception {
        Evaluable evaluable = new Add(new Constant(2.0f) , new Constant(5.0f));
        assertEquals(7.0f, evaluable.value());
        assertEquals(Float.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withDoubleAddition() throws Exception {
        Evaluable evaluable = new Add(new Constant(2.0d) , new Constant(2.0d));
        assertEquals(4.0d, evaluable.value());
        assertEquals(Double.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withIntegerSubtraction() throws Exception {
        Evaluable evaluable = new Sub(new Constant(5) , new Constant(3));
        assertEquals(2, evaluable.value());
        assertEquals(Integer.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withIntegerFloatSubtraction() throws Exception {
        Evaluable evaluable = new Sub(new Constant(5) , new Constant(3.0f));
        assertEquals(2.0f, evaluable.value());
        assertEquals(Float.class.getSimpleName(),evaluable.type());
    }

    @Test
    public void withIntegerIntegerMultiply() throws Exception {
        Evaluable evaluable = new Multiply(new Constant(5) , new Constant(3));
        assertEquals(15, evaluable.value());
        assertEquals(Integer.class.getSimpleName(),evaluable.type());
    }



}
