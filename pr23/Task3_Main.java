// task3_expression/Task3_Main.java
package task3_expression;

public class Task3_Main {
    public static void main(String[] args) {
        // x² - 2x + 1 = (x-1)²
        int x = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        Expression expr = new Add(
                new Subtract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
                ),
                new Const(1)
        );

        System.out.println("x = " + x + ", f(x) = " + expr.evaluate(x));

        // Пример из задания:
        int result = new Subtract(
                new Multiply(new Const(2), new Variable("x")),
                new Const(3)
        ).evaluate(5);
        System.out.println("2*x - 3 при x=5 = " + result);   // 7
    }
}