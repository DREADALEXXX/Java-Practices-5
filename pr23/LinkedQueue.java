// task2_queue_linked/LinkedQueue.java
package task2_queue_linked;

/**
 * Очередь на односвязном списке.
 * ИНВАРИАНТ: front → ... → rear → null; size = число узлов.
 * ПРЕ: enqueue — всегда (растёт); element/dequeue — size > 0
 */
public class LinkedQueue<T> extends AbstractQueue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> front;
    private Node<T> rear;

    @Override
    public void enqueue(T item) {
        checkNotFull();
        Node<T> node = new Node<>(item);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    @Override
    public T element() {
        checkNotEmpty();
        return front.data;
    }

    @Override
    public T dequeue() {
        checkNotEmpty();
        T item = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return item;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }
}