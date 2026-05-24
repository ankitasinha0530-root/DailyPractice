package com.dsal.leetcode.blind75.twoheaps.myheaps;

public class MyMinHeapMaxHeapTest {

    public static void main(String[] args) {
        MyMinHeap minHeap = new MyMinHeap();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(2);

        System.out.println("Min Heap root: " + minHeap.peek()); // 2
        System.out.println("Removed: " + minHeap.remove());      // 2
        System.out.println("New root: " + minHeap.peek());      // 5

        MyMaxHeap maxHeap = new MyMaxHeap();
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(2);

        System.out.println("Max Heap root: " + maxHeap.peek()); // 20
        System.out.println("Removed: " + maxHeap.remove());      // 20
        System.out.println("New root: " + maxHeap.peek());      // 10
    }

}