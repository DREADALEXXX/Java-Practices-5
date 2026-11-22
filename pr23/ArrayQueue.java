// task1_queue_array/ArrayQueue.java
package task1_queue_array;

/**
 * Обычный класс — методы через this (неявная ссылка).
 * ИНВАРИАНТ: те же.
 */
public class ArrayQueue<T> implements Queue<T> {
    private Object[] data = new Object[10];
    private int front = 0;
    private int rear = 9;
    private int size = 0;

    @Override
    public void enqueue(T item) {
        if (size == data.length) throw new IllegalStateException("Queue overflow");
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T element() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
        return (T) data[front];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        data = new Object[10];
        front = 0;
        rear = 9;
        size = 0;
    }
}