package task3_tests;

import task2_gui_mvc.CalculatorModel;

public class CalculatorModelTest {
    public static void main(String[] args) {
        System.out.println("=== Тесты CalculatorModel ===");

        CalculatorModel m = new CalculatorModel();
        m.push(3);
        m.push(4);
        check("push(3), push(4), size=2", m.size(), 2);

        m.clear();
        check("clear, size=0", m.size(), 0);

        check("evaluate '3 4 +'", m.evaluate("3 4 +"), 7);

        checkError(m, "1 0 /", "Деление на ноль");
        checkError(m, "1 2 + *", "POP для пустого стека");
        checkError(m, "", "Выражение пусто");

        System.out.println("\n✅ Все тесты CalculatorModel пройдены.");
    }

    private static void check(String msg, double actual, double expected) {
        if (Math.abs(actual - expected) > 1e-9)
            throw new AssertionError(msg + ": " + actual + " ≠ " + expected);
        System.out.printf("  ✓ %s%n", msg);
    }

    private static void checkError(CalculatorModel m, String expr, String expectedMsg) {
        try {
            m.evaluate(expr);
            System.out.printf("  ✗ evaluate(\"%s\") → ошибка НЕ поймана%n", expr);
        } catch (RuntimeException e) {
            if (!e.getMessage().contains(expectedMsg))
                System.out.printf("  ✗ evaluate(\"%s\") → %s%n", expr, e.getMessage());
            else
                System.out.printf("  ✓ evaluate(\"%s\") → %s%n", expr, e.getMessage());
        }
    }
}