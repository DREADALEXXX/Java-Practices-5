// task3_expression/Multiply.java
package task3_expression;

public class Multiply extends BinaryOperation {
    public Multiply(Expression l, Expression r) { super(l, r); }
    @Override protected int apply(int a, int b) { return a * b; }
}