package com.dsal.recurssions;

public class ILastIndexOfOccurenceInAnArray {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 2, 11, 9, 2};
        System.out.println("last Occurrence = " + lastIndexOfOccurrence(arr, 0, 2));
        System.out.println("last Occurrence = " + lastIndexOfOccurrence(arr, 0, 12));

        int[] arr2 = {7, 3, 2, 6, 2, 11, 9};
        System.out.println("last Occurrence = " + lastIndexOfOccurrence(arr2, 0, 2));
        System.out.println("last Occurrence = " + lastIndexOfOccurrence(arr2, 0, 15));

    }

    private static int lastIndexOfOccurrence(int[] arr, int idx, int target) {

        if(idx == arr.length){
            return -1;
        }

        int idxSoFar = lastIndexOfOccurrence(arr, idx + 1, target);

        if(idxSoFar == -1) {
            if (arr[idx] == target) {
                return idx;
            } else {
                return -1;
            }
        }else{
            return idxSoFar;
        }
    }
}
