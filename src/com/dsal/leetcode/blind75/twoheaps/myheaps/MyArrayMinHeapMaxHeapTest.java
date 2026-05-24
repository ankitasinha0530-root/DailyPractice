package com.dsal.leetcode.blind75.twoheaps.myheaps;

public class MyArrayMinHeapMaxHeapTest {

    public static void main(String[] args) {

        MyArrayMinHeap minHeap = new MyArrayMinHeap(10);

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(2);

        minHeap.printHeap();
        System.out.println(minHeap.remove());
        minHeap.printHeap();

        MyArrayMaxHeap maxHeap = new MyArrayMaxHeap(10);

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(2);

        maxHeap.printHeap();

        System.out.println("Max element: " + maxHeap.peek());

        System.out.println("Removed: " + maxHeap.remove());

        maxHeap.printHeap();
    }
}