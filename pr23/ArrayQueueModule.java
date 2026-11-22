// task1_queue_array/ArrayQueueModule.java
package task1_queue_array;

/**
 * Модульная реализация — ОДИН экземпляр через static-переменные.
 * ИНВАРИАНТ: 0 ≤ size ≤ capacity; при size > 0: front = (rear - size + 1 + cap) % cap
 * ПРЕД: enqueue — size < cap; element/dequeue — size > 0
 */
public class ArrayQueueModule {
    private static final int CAPACITY = 10;
    private static Object[] data = new Object[CAPACITY];
    private static int front = 0;
    private static int rear = CAPACITY - 1;   // пустая очередь
    private static int size = 0;

    // ПРЕ: size < CAPACITY
    // ПОСТ: size + 1, rear сдвинут
    public static <T> void enqueue(T item) {
        if (size == CAPACITY) throw new IllegalStateException("Queue overflow");
        rear = (rear + 1) % CAPACITY;
        data[rear] = item;
        size++;
    }

    // ПРЕ: size > 0
    // ПОСТ: size не меняется, возвращается data[front]
    @SuppressWarnings("unchecked")
    public static <T> T element() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
        return (T) data[front];
    }

    // ПРЕ: size > 0
    // ПОСТ: size - 1, front сдвинут
    @SuppressWarnings("unchecked")
    public static <T> T dequeue() {
        if (size == 0) throw new IllegalStateException("Queue underflow");
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    public static int size() { return size; }
    public static boolean isEmpty() { return size == 0; }

    // ПОСТ: size = 0
    public static void clear() {
        data = new Object[CAPACITY];
        front = 0;
        rear = CAPACITY - 1;
        size = 0;
    }
}