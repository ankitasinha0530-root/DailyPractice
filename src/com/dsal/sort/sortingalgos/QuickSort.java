package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {2, 7, 4, 6, 9, 8, 5};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static void quickSort(int[] arr, int low, int high) {

        if (arr.length < 1) {
            return;
        }

        if (low < high){ // This is very important condition

            int pivot = findPivotelElementPosition(arr, low, high);
            System.out.println("pivot : " + pivot);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

    }

    private static int findPivotelElementPosition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j){ // when it comes out of the loop it means we have traversed the whole loop
            System.out.println("i = " + i + ", j = " + j);
            while(arr[i] <= pivot){
                // send elements smaller than pivot to left and keep  moving right else if found bigger break
                System.out.println("i1 = " + i + ", j1 = " + j);
                i++;
            }
            while (arr[j] > pivot){
                // send elements bigger than pivot to right and keep coming left else if found smaller break
                System.out.println("i2 = " + i + ", j2 = " + j);
                j--;
            }
            if(i < j ){ //now if whole list is not traversed then arr[i] is bigger and arr[j]  is smaller than pivot hence swap
                swap (arr, i, j);
            }
        }
        System.out.println("low = " + low + ", j = " + j);
        if(i > 0 && j >0) {
            swap(arr, low, j);
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
