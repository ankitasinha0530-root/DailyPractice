package com.dsal.leetcode.blind75.twoheaps.myheaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMinHeap {

    private List<Integer> heap;

    public MyMinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void add(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(i) < heap.get(parent(i))) { // parent(i) = (i-1)/2
            int p = parent(i);  // parent(i) = (i-1)/2
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
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    private void heapifyDown(int i) {
        int n = heap.size();

        while (true) {
            int smallest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            if (left < n && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < n && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            Collections.swap(heap, i, smallest);
            i = smallest;
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }
}

