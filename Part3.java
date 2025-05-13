package com.example.project5oop;

public class Part3 {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // Test: Enqueue items
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("After enqueues: " + queue);

        // Test: Dequeue items
        System.out.println("Dequeue: " + queue.dequeue()); // A
        System.out.println("Dequeue: " + queue.dequeue()); // B
        System.out.println("After dequeues: " + queue);

        // Enqueue more
        queue.enqueue("D");
        queue.enqueue("E");
        System.out.println("Final Queue: " + queue);

        // Dequeue all
        while (queue.getSize() > 0) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

        // Try dequeue from empty queue
        System.out.println("Dequeue from empty: " + queue.dequeue());
    }
}



class Queue<T> extends LinkedList<T> {

    public void enqueue(T item) {
        add(item); // FIFO: add to end
    }

    public T dequeue() {
        if (getSize() == 0) return null;
        return remove(0); // FIFO: remove from front
    }
}
