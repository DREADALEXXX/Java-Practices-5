// task1_stack/Stack.java
package task1_stack;

public interface Stack<T> {
    void push(T item);    // добавить на вершину
    T pop();              // удалить с вершины
    T peek();             // посмотреть вершину
    boolean isEmpty();
    int size();
}