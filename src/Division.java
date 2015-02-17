/**
 * Created by Javichu on 17/02/2015.
 */
public class Division extends Operation{

    public Division(Expression leftExpression, Expression rightExpression) {
        super(leftExpression,rightExpression);
    }

    public int evaluate() {
        return leftExpression.evaluate() / rightExpression.evaluate();
    }
}
