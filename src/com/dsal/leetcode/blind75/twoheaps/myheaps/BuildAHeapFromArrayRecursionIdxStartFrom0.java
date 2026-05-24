package com.dsal.leetcode.blind75.twoheaps.myheaps;

import java.util.Arrays;

public class BuildAHeapFromArrayRecursionIdxStartFrom0 {

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 2, 8}; // adding 0th element as -1 as we want actual element from 1

        buildHeap(arr, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
    private static void buildHeap(int[] arr, int n){

        // we can skip leafNodes, leafNodes will always start from (n/2 + 1) - always take floor value

        for (int i = n/2-1; i >= 0; i--) {
            simpleHeapify(arr, n, i);
        }
    }

    // To convert an array to a heap
    private static void simpleHeapify(int[] arr, int n, int i){

        int largestIdx = i;
        int leftIdx = 2*i + 1;
        int rightIdx = 2*i + 2;

        if (leftIdx <= n && arr[largestIdx] < arr[leftIdx]){
            largestIdx = leftIdx;
        }

        if (rightIdx <= n && arr[largestIdx] < arr[rightIdx]){
            largestIdx = rightIdx;
        }

        if(largestIdx != i){
            swap(arr, largestIdx, i);
            i = largestIdx;
            simpleHeapify(arr, n, i);
        }
    }

    private static void swap(int[] arr, int largestIdx, int i){
        int temp = arr[largestIdx];
        arr[largestIdx] = arr[i];
        arr[i] = temp;

    }
}
