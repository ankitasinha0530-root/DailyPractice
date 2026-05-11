package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {10, 7, 4, 6, 9, 8, 5};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static void bubbleSort(int[] arr) {
    int n = arr.length;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < n-i-1 ; j++) {
                if(arr[j] > arr[j+1]){
                    swapEle(arr, j);
                }
            }
        }
    }

    private static void swapEle(int[] arr, int j) {

        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
}
