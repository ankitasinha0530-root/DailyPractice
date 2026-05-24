package com.dsal.leetcode.blind75.twoheaps.myheaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMaxHeap {

    private List<Integer> heap;

    public MyMaxHeap() {
        heap = new ArrayList<>();
    }

    // Parent
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Left Child
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Right child
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void add(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int i) {

        while (i > 0 && heap.get(i) > heap.get(parent(i))) { // parent i = i-1/2
            int p = parent(i);  // parent i = i-1/2
            Collections.swap(heap, i, p);
            i = p;
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public int remove() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last); // set 0th index with last element
            heapifyDown(0);
        }

        return root;
    }

    private void heapifyDown(int i) {

        int n = heap.size();

        while (true) {
            int largestIdx = i;
            int leftIdx = leftChild(i);  // 2*i+1
            int right = rightChild(i); // 2*i+2

            if (leftIdx < n && heap.get(leftIdx) > heap.get(largestIdx)) {
                largestIdx = leftIdx;
            }

            if (right < n && heap.get(right) > heap.get(largestIdx)) {
                largestIdx = right;
            }

            if (largestIdx == i) {
                break;
            }

            Collections.swap(heap, i, largestIdx);
            i = largestIdx;
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }
}
