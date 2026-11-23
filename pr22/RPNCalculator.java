package task1_rpn_calculator;

import java.util.*;

public class RPNCalculator {

    public static double evaluate(String expression) {
        if (expression == null || expression.isBlank())
            throw new IllegalArgumentException("Выражение пусто");

        Deque<Double> stack = new ArrayDeque<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    if (stack.size() < 2)
                        throw new IllegalStateException("Невозможно выполнить POP для пустого стека");
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = switch (token) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> {
                            if (b == 0) throw new ArithmeticException("Деление на ноль");
                            yield a / b;
                        }
                        default -> throw new IllegalStateException();
                    };
                    stack.push(result);
                }
                default -> {
                    try {
                        stack.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Неизвестный токен: " + token);
                    }
                }
            }
        }

        if (stack.size() != 1)
            throw new IllegalStateException("Некорректное выражение: осталось " + stack.size() + " элементов");

        return stack.pop();
    }
}