
public class Sum extends Operation{
    public Sum(Expression leftExpression, Expression rightExpression) {
        super(leftExpression,rightExpression);
    }

    public int evaluate() {
        return leftExpression.evaluate() + rightExpression.evaluate();
    }
}
