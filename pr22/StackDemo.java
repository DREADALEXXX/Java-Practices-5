// task3_stack_demo/StackDemo.java
package task3_stack_demo;

import task1_stack.ArrayStack;
import task1_stack.Stack;
import task2_stack_mvc.StackController;
import task2_stack_mvc.StackView;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> model = new ArrayStack<>();
        StackView view = new StackView();
        StackController<Integer> controller = new StackController<>(model, view);

        System.out.println("=== Демонстрация стека (MVC) ===");
        controller.push(1);
        controller.push(2);
        controller.push(3);
        controller.pop();
        controller.pop();
        controller.show();

        System.out.println("\n=== Проверка LIFO ===");
        Stack<String> strStack = new ArrayStack<>();
        strStack.push("A");
        strStack.push("B");
        strStack.push("C");
        System.out.println("pop: " + strStack.pop());   // C (последний)
        System.out.println("pop: " + strStack.pop());   // B
        System.out.println("pop: " + strStack.pop());   // A
        System.out.println("isEmpty: " + strStack.isEmpty());   // true
    }
}