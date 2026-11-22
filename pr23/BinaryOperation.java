// task3_expression/BinaryOperation.java
package task3_expression;

public abstract class BinaryOperation implements Expression {
    protected final Expression left, right;

    protected BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate(int x) {
        return apply(left.evaluate(x), right.evaluate(x));
    }

    protected abstract int apply(int a, int b);
}