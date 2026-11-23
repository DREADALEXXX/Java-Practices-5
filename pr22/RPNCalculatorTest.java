package task3_tests;

import task1_rpn_calculator.RPNCalculator;

public class RPNCalculatorTest {
    public static void main(String[] args) {
        System.out.println("=== Корректные выражения ===");
        check("3 4 +", 7);
        check("3 4 + 2 *", 14);
        check("5 1 2 + 4 * + 3 -", 14);
        check("10 2 /", 5);
        check("2 3 * 4 5 * +", 26);

        System.out.println("\n=== Ошибочные выражения ===");
        checkError("", "Выражение пусто");
        checkError("   ", "Выражение пусто");
        checkError("3 +", "POP для пустого стека");
        checkError("1 2 + *", "POP для пустого стека");
        checkError("3 4", "Некорректное выражение");
        checkError("1 0 /", "Деление на ноль");
        checkError("abc", "Неизвестный токен");
        checkError("3 4 5", "Некорректное выражение");

        System.out.println("\n✅ Все тесты RPNCalculator пройдены.");
    }

    private static void check(String expr, double expected) {
        double actual = RPNCalculator.evaluate(expr);
        if (Math.abs(actual - expected) > 1e-9)
            throw new AssertionError(expr + " → " + actual + " ≠ " + expected);
        System.out.printf("  ✓ %-25s = %.2f%n", expr, actual);
    }

    private static void checkError(String expr, String expectedMsg) {
        try {
            RPNCalculator.evaluate(expr);
            System.out.printf("  ✗ %-25s → ошибка НЕ поймана%n", "\"" + expr + "\"");
        } catch (RuntimeException e) {
            if (!e.getMessage().contains(expectedMsg))
                System.out.printf("  ✗ %-25s → %s%n", "\"" + expr + "\"", e.getMessage());
            else
                System.out.printf("  ✓ %-25s → %s%n", "\"" + expr + "\"", e.getMessage());
        }
    }
}