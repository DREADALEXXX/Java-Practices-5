package task2_gui_mvc;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorModel {
    private final Deque<Double> stack = new ArrayDeque<>();

    public void push(double value) { stack.push(value); }

    public double pop() {
        if (stack.isEmpty())
            throw new IllegalStateException("Невозможно выполнить POP для пустого стека");
        return stack.pop();
    }

    public double evaluate(String expression) {
        stack.clear();
        if (expression == null || expression.isBlank())
            throw new IllegalArgumentException("Выражение пусто");

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

    public void clear() { stack.clear(); }
    public int size()   { return stack.size(); }
}