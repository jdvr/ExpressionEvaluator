/**
 * Created by Javichu on 09/02/2015.
 */
public class Expression {

    private Node root;

    public Expression(int value) {
        root = new Constant(value);
    }

    public Expression(String operator, int firstExpression, int secondExpression) {
        root = new Operator(operator,new Constant(firstExpression),new Constant(secondExpression));
    }

    public Expression(String operator, Expression firstExpression, int secondExpression) {
        root = new Operator(operator,new Constant(firstExpression.evaluate()),new Constant(secondExpression));
    }

    public Expression(String operator, Expression firstExpression, Expression secondExpression) {
        root = new Operator(operator,new Constant(firstExpression.evaluate()),new Constant(secondExpression.evaluate()));
    }

    public int evaluate() {
        return root.evaluate();
    }

    private interface Node {
        int evaluate();
    }

    private class Constant implements Node {

        private int value;

        public Constant(int value){
            this.value = value;
        }

        @Override
        public int evaluate() {
            return value;
        }
    }

    private class Operator implements Node {

        private Node rightNode;
        private Node leftNode;
        private String operator;

        public Operator(String operator, Node rightNode, Node leftNode){
            this.operator = operator;
            this.rightNode = rightNode;
            this.leftNode = leftNode;
        }

        @Override
        public int evaluate() {
            //TODO: aqui toa la movida de los case para los operadores = caca
            return rightNode.evaluate() + leftNode.evaluate();
        }
    }
}
