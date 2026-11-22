// tests/ExpressionTests.java
package tests;

import task4_parser.ExpressionParser;

public class ExpressionTests {
    public static void main(String[] args) {
        ExpressionParser p = new ExpressionParser();

        check(p, "3 + 5 * 2", 0, 0, 0, 13);
        check(p, "(3 + 5) * 2", 0, 0, 0, 16);
        check(p, "-3 + 5", 0, 0, 0, 2);
        check(p, "x * (y - 2) * z + 1", 2, 3, 4, 9);
        check(p, "2 - 3 - 4", 0, 0, 0, -5);   // лево-ассоц.
        check(p, "100 / 10 / 2", 0, 0, 0, 5);

        // Деление на ноль
        try {
            p.parse("1 / 0").evaluate(0, 0, 0);
            System.out.println("Division by zero: НЕ ПОЙМАН ❌");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero: OK ✅");
        }

        System.out.println("Все тесты пройдены.");
    }

    private static void check(ExpressionParser p, String expr, int x, int y, int z, int expected) {
        int actual = p.parse(expr).evaluate(x, y, z);
        if (actual != expected) throw new AssertionError(expr + " → " + actual + " ≠ " + expected);
        System.out.println(expr + " = " + actual + " ✅");
    }
}