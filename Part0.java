package com.example.project5oop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part0 {

    public static void main(String[] args) {
        int numElements = 100_000;
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Test 1: Insertion at beginning
        System.out.println("=== Part 0.1: Insertion at Beginning ===");
        testInsertionAtBeginning(new ArrayList<>(), "ArrayList", numElements, formatter);
        testInsertionAtBeginning(new LinkedList<>(), "LinkedList", numElements, formatter);

        // Test 2: Access by index
        System.out.println("\n=== Part 0.2: Access by Index ===");
        testAccessByIndex(new ArrayList<>(generateTestData(numElements)), "ArrayList", numElements, formatter);
        testAccessByIndex(new LinkedList<>(generateTestData(numElements)), "LinkedList", numElements, formatter);

        // Test 3: Remove from beginning
        System.out.println("\n=== Part 0.3: Remove from Beginning ===");
        testRemoveFromBeginning(new ArrayList<>(generateTestData(numElements)), "ArrayList", numElements, formatter);
        testRemoveFromBeginning(new LinkedList<>(generateTestData(numElements)), "LinkedList", numElements, formatter);
    }

    private static void testInsertionAtBeginning(List<Integer> list, String type, int n, DecimalFormat fmt) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();
        System.out.println(type + " insertion time: " + fmt.format(end - start) + " ns");
    }

    private static void testAccessByIndex(List<Integer> list, String type, int n, DecimalFormat fmt) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.get(i);
        }
        long end = System.nanoTime();
        System.out.println(type + " access time: " + fmt.format(end - start) + " ns");
    }

    private static void testRemoveFromBeginning(List<Integer> list, String type, int n, DecimalFormat fmt) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
        long end = System.nanoTime();
        System.out.println(type + " remove time: " + fmt.format(end - start) + " ns");
    }

    private static List<Integer> generateTestData(int n) {
        List<Integer> data = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        return data;
    }
}
