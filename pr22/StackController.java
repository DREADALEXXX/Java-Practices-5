// task2_stack_mvc/StackController.java
package task2_stack_mvc;

import task1_stack.Stack;

public class StackController<T> {
    private final Stack<T> model;
    private final StackView view;

    public StackController(Stack<T> model, StackView view) {
        this.model = model;
        this.view = view;
    }

    public void push(T item) {
        model.push(item);
        view.printMessage("push(" + item + ")");
        view.print(model);
    }

    public T pop() {
        if (model.isEmpty()) {
            view.printMessage("Ошибка: стек пуст");
            return null;
        }
        T item = model.pop();
        view.printMessage("pop() → " + item);
        view.print(model);
        return item;
    }

    public void show() {
        view.print(model);
    }
}