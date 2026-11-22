// task4_parser/Task4_Main.java
package task4_parser;

public class Task4_Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();

        // Пример из задания: x * (y - 2) * z + 1
        String expr = "x * (y - 2) * z + 1";
        TripleExpression e = parser.parse(expr);

        System.out.println("Выражение: " + expr);
        System.out.println("x=2, y=3, z=4 → " + e.evaluate(2, 3, 4));   // 2*1*4+1 = 9

        // Задание 4.5: 1000000*x*x*x*x*x/(x-1)
        String expr2 = "1000000*x*x*x*x*x/(x-1)";
        TripleExpression e2 = parser.parse(expr2);

        System.out.println("\n x  f");
        for (int x = 0; x <= 10; x++) {
            try {
                int result = e2.evaluate(x, 0, 0);
                System.out.println(" " + x + "  " + result);
            } catch (ArithmeticException ex) {
                System.out.println(" " + x + "  division by zero");
            } catch (Exception ex) {
                System.out.println(" " + x + "  overflow");
            }
        }
    }
}