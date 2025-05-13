package com.example.project5oop;

public class Part2 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Test: Push items
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("After pushes: " + stack);

        // Test: Pop items
        System.out.println("Pop: " + stack.pop()); // C
        System.out.println("Pop: " + stack.pop()); // B
        System.out.println("After pops: " + stack);

        // Push more
        stack.push("D");
        stack.push("E");
        System.out.println("Final Stack: " + stack);

        // Pop all
        while (stack.getSize() > 0) {
            System.out.println("Pop: " + stack.pop());
        }

        // Try popping from empty stack (should print null)
        System.out.println("Pop from empty: " + stack.pop());
    }
}

//

class Stack<T> extends LinkedList<T> {

    public void push(T item) {
        addFirst(item); // LIFO: newest on top
    }

    public T pop() {
        if (getSize() == 0) return null;
        return remove(0); // LIFO: remove from top
    }
}

