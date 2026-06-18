package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JAllIndicesOfOccurenceInAnArray {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 2, 11, 9, 2};
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr, 0, 2)));
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr, 0, 12)));

        int[] arr2 = {7, 3, 2, 6, 2, 11, 9};
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr2, 0, 2)));
        System.out.println("All Occurrence = " + Arrays.toString(AllIndexOfOccurrence(arr2, 0, 15)));

    }

    private static int[] AllIndexOfOccurrence(int[] arr, int idx, int target) {
        
        List<Integer> result = new ArrayList<>();

        return Arrays.stream(AllIndexOfOccurrenceHelper(arr, idx, target, result)).toArray();
    }

    private static int[] AllIndexOfOccurrenceHelper(int[] arr, int idx, int target, List<Integer> result) {

        if(idx == arr.length){
            return new int[0];
        }

        if(arr[idx] == target){
            result.add(idx);
        }
        AllIndexOfOccurrenceHelper(arr, idx+1, target, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
