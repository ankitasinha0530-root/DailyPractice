package com.dsal.leetcode.blind75.twoheaps.myheaps;

import java.util.Arrays;

public class MyArrayMinHeap {

    private int[] heap;
    private int size;

    public MyArrayMinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // left child index
    private int left(int i) {
        return 2 * i + 1;
    }

    // right child index
    private int right(int i) {
        return 2 * i + 2;
    }

    // insert element
    public void add(int val) {

        // put at end
        heap[size] = val;

        int current = size;
        size++;

        // heapify up
        while (current > 0 && heap[current] < heap[parent(current)]) {

            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;

            current = parent(current);
        }
    }

    // remove minimum element
    public int remove() {

        if (size == 0) {
            throw new RuntimeException("Heap empty");
        }

        int root = heap[0];

        // move last element to root
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return root;
    }

    private void heapifyDown(int i) {

        while (true) {

            int smallest = i;

            int left = left(i);
            int right = right(i);

            // compare left child
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            // compare right child
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            // already correct
            if (smallest == i) {
                break;
            }

            // swap
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }
    }

    // print heap
    public void printHeap() {

//        for (int i = 0; i < size; i++) {
//            System.out.print(heap[i] + " ");
//        }

        System.out.println(Arrays.toString(heap));
        System.out.println();
    }
}

