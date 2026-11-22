// task2_queue_linked/AbstractQueue.java
package task2_queue_linked;

public abstract class AbstractQueue<T> implements Queue<T> {
    protected int size = 0;

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    // Общая проверка для enqueue
    protected void checkNotFull() { /* по умолчанию — без ограничений */ }

    // Общая проверка для dequeue/element
    protected void checkNotEmpty() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
    }
}
