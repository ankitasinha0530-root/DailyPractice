package com.dsal.recurssions;

public class H1stIndexOfOccurenceInAnArray {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 2, 11, 9};

        System.out.println("first Occurrence = " + firstIndexOfOccurrence(arr, 0, 2));

    }

    private static int firstIndexOfOccurrence(int[] arr, int idx, int target) {

        if (idx == arr.length - 1) {
            return -1;
        }

        if (arr[idx] == target) {
            return idx; // we found the first index so return
        } else {
            return firstIndexOfOccurrence(arr, idx + 1, target);
        }
    }
}
