package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {10, 7, 4, 6, 9, 8, 5};
        selectionSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if (!(min == i)){
                swapElem(arr, min, i);
            }
        }
    }

    private static void swapElem(int[] arr, int min, int i) {

        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }

}
