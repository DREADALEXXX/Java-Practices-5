// task1_queue_array/ArrayQueueADT.java
package task1_queue_array;

/**
 * АТД — все методы ПРИНИМАЮТ ссылку на экземпляр (явно).
 * ИНВАРИАНТ: те же, что в ArrayQueueModule.
 */
public class ArrayQueueADT {
    private Object[] data = new Object[10];
    private int front = 0;
    private int rear = 9;
    private int size = 0;

    // ПРЕ: q.size < q.data.length
    // ПОСТ: q.size + 1
    public static <T> void enqueue(ArrayQueueADT q, T item) {
        if (q.size == q.data.length) throw new IllegalStateException("Queue overflow");
        q.rear = (q.rear + 1) % q.data.length;
        q.data[q.rear] = item;
        q.size++;
    }

    // ПРЕ: q.size > 0
    @SuppressWarnings("unchecked")
    public static <T> T element(ArrayQueueADT q) {
        if (q.size == 0) throw new IllegalStateException("Queue underflow");
        return (T) q.data[q.front];
    }

    // ПРЕ: q.size > 0
    @SuppressWarnings("unchecked")
    public static <T> T dequeue(ArrayQueueADT q) {
        if (q.size == 0) throw new IllegalStateException("Queue underflow");
        T item = (T) q.data[q.front];
        q.data[q.front] = null;
        q.front = (q.front + 1) % q.data.length;
        q.size--;
        return item;
    }

    public static int size(ArrayQueueADT q) { return q.size; }
    public static boolean isEmpty(ArrayQueueADT q) { return q.size == 0; }

    // ПОСТ: q.size = 0
    public static void clear(ArrayQueueADT q) {
        q.data = new Object[10];
        q.front = 0;
        q.rear = 9;
        q.size = 0;
    }
}
