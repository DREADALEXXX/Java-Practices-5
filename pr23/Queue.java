// task2_queue_linked/Queue.java
package task2_queue_linked;

public interface Queue<T> {
    void enqueue(T item);
    T element();
    T dequeue();
    int size();
    boolean isEmpty();
    void clear();
}