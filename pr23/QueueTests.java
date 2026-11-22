// tests/QueueTests.java
package tests;

import task1_queue_array.ArrayQueue;

public class QueueTests {
    public static void main(String[] args) {
        // === ArrayQueue ===
        ArrayQueue<Integer> q = new ArrayQueue<>();
        assert q.isEmpty();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        assert q.size() == 3;
        assert q.element() == 1;
        assert q.dequeue() == 1;
        assert q.size() == 2;
        q.clear();
        assert q.isEmpty();
        System.out.println("ArrayQueue: OK");

        // === Проверка overflow ===
        ArrayQueue<Integer> full = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) full.enqueue(i);
        try {
            full.enqueue(11);
            System.out.println("ArrayQueue overflow: НЕ ПОЙМАН ❌");
        } catch (IllegalStateException e) {
            System.out.println("ArrayQueue overflow: OK ✅");
        }

        // === Проверка underflow ===
        try {
            new ArrayQueue<Integer>().dequeue();
            System.out.println("ArrayQueue underflow: НЕ ПОЙМАН ❌");
        } catch (IllegalStateException e) {
            System.out.println("ArrayQueue underflow: OK ✅");
        }
    }
}