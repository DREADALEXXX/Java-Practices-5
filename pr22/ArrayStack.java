// task1_stack/ArrayStack.java
package task1_stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private Object[] data;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        data = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (top + 1 == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Стек пуст");
        T item = (T) data[top];
        data[top--] = null;
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Стек пуст");
        return (T) data[top];
    }

    @Override public boolean isEmpty() { return top == -1; }
    @Override public int size()        { return top + 1; }
}