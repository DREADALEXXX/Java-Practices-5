// task3_expression/Divide.java
package task3_expression;

public class Divide extends BinaryOperation {
    public Divide(Expression l, Expression r) { super(l, r); }
    @Override protected int apply(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}