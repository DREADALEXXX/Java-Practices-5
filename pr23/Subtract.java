// task3_expression/Subtract.java
package task3_expression;

public class Subtract extends BinaryOperation {
    public Subtract(Expression l, Expression r) { super(l, r); }
    @Override protected int apply(int a, int b) { return a - b; }
}