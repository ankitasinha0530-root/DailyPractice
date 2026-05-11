package com.dsal.sort.sortingalgos;

import java.util.Arrays;

public class MergeSortDemo {

//    Time Complexity = O(nlogn)
//    Space Complexity = O(n)

    public static void main(String[] args) {

//        int[] arr = {2, 7, 4, 6, 9, 8, 5};
        int[] arr = {8, 5, 7, 9, 3, 4, 2, 6};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static void mergeSort(int[] arr, int left, int right) {

        if(arr.length < 1){
            return;
        }
        if(left < right) { // Always left < right to proceed with further splitting and recursion call
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, right, mid);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid) {

        int[] b = new int[arr.length];

        int i = left; // this is important
        int j = mid+1;
        int k = left; // this is important

            while (i <= mid && j <= right){
                if(arr[i] < arr[j]){
                    b[k++] = arr[i++];
                }else {
                    b[k++] = arr[j++];
                }
            }
            if (i > mid) {
                while (j <= right) {
                    b[k++] = arr[j++];
                }
            }else{
                while(i <= mid){
                    b[k++] = arr[i++];
                }
            }

        for (k = left; k <= right; k++){
            arr[k] = b[k];
        }
    }
}

