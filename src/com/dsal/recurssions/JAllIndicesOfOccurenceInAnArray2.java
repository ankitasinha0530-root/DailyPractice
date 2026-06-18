package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JAllIndicesOfOccurenceInAnArray2 {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 2, 11, 9, 2};
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr, 0, 2)));
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr, 0, 12)));

        int[] arr2 = {7, 3, 2, 6, 2, 11, 9};
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr2, 0, 2)));
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr2, 0, 15)));

    }

    private static int[] AllIndexOfOccurrence(int[] arr, int idx, int target) {

        return AllIndexOfOccurrenceHelper(arr, idx, target, 0);
    }

    private static int[] AllIndexOfOccurrenceHelper(int[] arr, int idx, int target, int countSoFar) {

        if(idx == arr.length){
            return new int[countSoFar];
        }

        if(arr[idx] == target) {
            int[] resultArray = AllIndexOfOccurrenceHelper(arr, idx + 1, target, countSoFar + 1);
            resultArray[countSoFar] = idx;
            return resultArray;
        }else{
            int[] resultArray =  AllIndexOfOccurrenceHelper(arr, idx + 1, target, countSoFar);
            return resultArray;
        }
    }
}
