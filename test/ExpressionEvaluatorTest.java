import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Javichu on 09/02/2015.
 */
public class ExpressionEvaluatorTest {

    @Test
    public void withOneElement() throws Exception {
        Expression expression = new Expression(5);
        Interpreter interpreter = new Interpreter();
        assertEquals(5,interpreter.evaluate(expression));
    }

    @Test
    public void withOtherElement() throws Exception {
        Expression expression = new Expression(8);
        Interpreter interpreter = new Interpreter();
        assertEquals(8,interpreter.evaluate(expression));
    }

    @Test
    public void plusTwoElements() throws Exception {
        Expression expression = new Expression("+",2,8);
        Interpreter interpreter = new Interpreter();
        assertEquals(10,interpreter.evaluate(expression));
    }

    @Test
    public void subTwoElements() throws Exception {
        Expression expression = new Expression("-",8,2);
        Interpreter interpreter = new Interpreter();
        assertEquals(6,interpreter.evaluate(expression));
    }

    @Test
    public void multiplyTwoElements() throws Exception {
        Expression expression = new Expression("*",8,2);
        Interpreter interpreter = new Interpreter();
        assertEquals(16,interpreter.evaluate(expression));
    }

    @Test
    public void plusALotOfElements() throws Exception {
        Expression expression = new Expression("+",new Expression("+",new Expression("+",1,8),9),new Expression("+",2,4));
        Interpreter interpreter = new Interpreter();
        assertEquals(24,interpreter.evaluate(expression));
    }

    @Test
    public void rewardTest() throws Exception {
        Expression expression = new Expression("+",new Expression("*",new Expression("+",1,8),9),new Expression("-",2,4));
        Interpreter interpreter = new Interpreter();
        assertEquals(79,interpreter.evaluate(expression));
    }
}
