// task3_expression/Const.java
package task3_expression;

public class Const implements Expression {
    private final int value;

    public Const(int value) { this.value = value; }

    @Override
    public int evaluate(int x) { return value; }
}