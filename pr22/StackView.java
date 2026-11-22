// task2_stack_mvc/StackView.java
package task2_stack_mvc;

import task1_stack.Stack;

public class StackView {
    public void print(Stack<?> stack) {
        if (stack.isEmpty()) {
            System.out.println("Стек: (пуст)");
        } else {
            System.out.println("Стек (size=" + stack.size() + "): top = " + stack.peek());
        }
    }

    public void printMessage(String msg) {
        System.out.println("[UI] " + msg);
    }
}