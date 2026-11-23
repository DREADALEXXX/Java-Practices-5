package task1_rpn_calculator;

public class Task1_Main {
    public static void main(String[] args) {
        System.out.println(RPNCalculator.evaluate("3 4 +"));            // 7.0
        System.out.println(RPNCalculator.evaluate("3 4 + 2 *"));        // 14.0
        System.out.println(RPNCalculator.evaluate("5 1 2 + 4 * + 3 -"));// 14.0
        System.out.println(RPNCalculator.evaluate("10 2 /"));           // 5.0
    }
}