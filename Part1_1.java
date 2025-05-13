package com.example.project5oop;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Part1_1 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Test: Add elements
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("After adding A, B, C, D: " + list);

        // Test: Add at index
        list.add(2, "X");
        System.out.println("After inserting X at index 2: " + list);

        // Test: Add at first
        list.addFirst("Z");
        System.out.println("After addFirst Z: " + list);

        // Test: Get by index
        System.out.println("Element at index 3: " + list.get(3));

        // Test: Remove by element
        list.remove("C");
        System.out.println("After removing 'C': " + list);

        // Test: Remove by index
        list.remove(0);
        System.out.println("After removing index 0: " + list);

        // Test: Remove all occurrences
        list.add("B");
        list.add("B");
        System.out.println("Before removeAll B: " + list);
        list.removeAll("B");
        System.out.println("After removeAll B: " + list);

        // Test: getSize
        System.out.println("Size: " + list.getSize());

        // Test: Iterator
        System.out.print("Iterating: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}

// ==================== LinkedList Implementation ====================

class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T e) {
        Node<T> newNode = new Node<>(last, e, null);
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
        size++;
    }

    public void add(int index, T e) {
        checkPositionIndex(index);
        if (index == size) {
            add(e);
        } else {
            Node<T> target = getNode(index);
            Node<T> prev = target.prev;
            Node<T> newNode = new Node<>(prev, e, target);
            target.prev = newNode;
            if (prev != null) {
                prev.next = newNode;
            } else {
                first = newNode;
            }
            size++;
        }
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(null, e, first);
        if (first != null) {
            first.prev = newNode;
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).item;
    }

    public boolean remove(T e) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (x.item.equals(e)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        checkElementIndex(index);
        return unlink(getNode(index));
    }

    public void removeAll(T e) {
        Node<T> x = first;
        while (x != null) {
            Node<T> next = x.next;
            if (x.item.equals(e)) {
                unlink(x);
            }
            x = next;
        }
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> x = first;
        while (x != null) {
            sb.append(x.item);
            x = x.next;
            if (x != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> getNode(int index) {
        checkElementIndex(index);
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private T unlink(Node<T> x) {
        T element = x.item;
        Node<T> next = x.next;
        Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (current == null) throw new NoSuchElementException();
            T val = current.item;
            current = current.next;
            return val;
        }
    }
}

