// task3_expression/Add.java
package task3_expression;

public class Add extends BinaryOperation {
    public Add(Expression l, Expression r) { super(l, r); }
    @Override protected int apply(int a, int b) { return a + b; }
}