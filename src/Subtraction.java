
public class Subtraction extends Operation{

    public Subtraction(Expression leftExpression, Expression rightExpression) {
        super(leftExpression,rightExpression);
    }

    public int evaluate() {
        return leftExpression.evaluate() - rightExpression.evaluate();
    }
}
