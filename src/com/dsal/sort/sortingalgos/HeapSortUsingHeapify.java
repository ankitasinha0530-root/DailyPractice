package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class HeapSortUsingHeapify {

    public static void main(String[] args) {

        int[] arr = {10, 7, 4, 6, 9, 8, 5};
        heapSortUsingHeapify(arr);
        System.out.println("Final Result : " + Arrays.toString(arr));

    }

    private static void heapSortUsingHeapify(int[] arr) {
        int n = arr.length;
        // step 1 : create a maxHeap first so the max element would be at the top
        for (int i = (n/2)-1; i >= 0; i--) { // n/2-1 as array is starting from 0 elements
            heapifyForMaxHeap(arr, n, i);
        }
        System.out.println(Arrays.toString(arr));
        // step 2 : Extract element one by one
        for (int i = n-1; i > 0; i--) {
            swap(arr, i, 0); // Swap 0th element and ith Element, which is the last element
            heapifyForMaxHeap(arr, i, 0); // i coz that is the new length of array and start from 0
        }
    }

    private static void heapifyForMaxHeap(int[] arr, int n, int i) {
        int largestIdx = i; // assuming largest is at bottom of the heap and then check if its a heap next

        int leftIdx = 2*i + 1;              // Find left Child Index
        int rightIdx = 2*i + 2;             // Find right child Index

        if(leftIdx < n && arr[largestIdx] < arr[leftIdx]){
            largestIdx = leftIdx;
        }
        if(rightIdx < n && arr[largestIdx] < arr[rightIdx]){
            largestIdx = rightIdx;
        }

        if(largestIdx != i){
            swap(arr, largestIdx, i);
            heapifyForMaxHeap(arr, n, largestIdx);
        }

    }

    private static void swap(int[] arr, int largestIdx, int i){
        int temp = arr[i];
        arr[i] = arr[largestIdx];
        arr[largestIdx] = temp;
    }
}

/**
Steps :-

1. Build A MaxHeap first from the array by giving i = n/2, starting from last non-leaf element
2. Then maxHeap will be created.
 3. Now loop through each element of max Heap
    a. swap 1st and last element
    b. then skip last element
    c. then call heapify from 1st element to skipping last element as the the max will always move to last
    d. repeat the steps
 */
