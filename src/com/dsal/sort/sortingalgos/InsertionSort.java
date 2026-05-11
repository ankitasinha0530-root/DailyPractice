package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {10, 7, 4, 6, 9, 8, 5};
        insertionSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i-1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }
    }

}
