package task3_tests;

import task2_gui_mvc.CalculatorModel;

import java.util.Scanner;

public class FoolProofDemo {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RPN-калькулятор (защита от дурака) ===");
        System.out.println("Пример: 3 4 + 2 *   (для выхода — 'exit')");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;

            if (input.isEmpty()) {
                System.out.println("❌ Пустой ввод. Введите выражение.");
                continue;
            }

            try {
                double result = model.evaluate(input);
                System.out.println("✅ Результат: " + result);
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println("❌ " + ex.getMessage());
            } catch (ArithmeticException ex) {
                System.out.println("❌ Арифметическая ошибка: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("❌ Непредвиденная ошибка: " + ex.getMessage());
            }
        }

        System.out.println("Выход.");
        sc.close();
    }
}