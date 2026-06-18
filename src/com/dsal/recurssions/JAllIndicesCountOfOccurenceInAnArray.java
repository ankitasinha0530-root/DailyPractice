package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JAllIndicesCountOfOccurenceInAnArray {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 2, 11, 9, 2};
        System.out.println("All Occurrence = " + AllIndexOfOccurrence(arr, 0, 2));
        System.out.println("All Occurrence = " + AllIndexOfOccurrence(arr, 0, 12));

        System.out.println("All Occurrence 2 = " + AllIndexOfOccurrence2(arr, 0, 2));
        System.out.println("All Occurrence 2 = " + AllIndexOfOccurrence2(arr, 0, 12));

        int[] arr2 = {7, 3, 2, 6, 2, 11, 9};
        System.out.println("All Occurrence = " + AllIndexOfOccurrence(arr2, 0, 2));
        System.out.println("All Occurrence = " + AllIndexOfOccurrence(arr2, 0, 15));

        System.out.println("All Occurrence 2 = " + AllIndexOfOccurrence2(arr2, 0, 2));
        System.out.println("All Occurrence 2 = " + AllIndexOfOccurrence2(arr2, 0, 15));

    }

    private static int AllIndexOfOccurrence(int[] arr, int idx, int target) {

        return AllIndexOfOccurrenceHelper(arr, idx, target, 0);
    }

    private static int AllIndexOfOccurrenceHelper(int[] arr, int idx, int target, int countOfIndex) {

        if(idx == arr.length){
            return 0;
        }

        countOfIndex = AllIndexOfOccurrenceHelper(arr, idx+1, target, countOfIndex);

        if(arr[idx] == target){
            countOfIndex++;
        }
        return countOfIndex;
    }

    private static int AllIndexOfOccurrence2(int[] arr, int idx, int target) {

        return AllIndexOfOccurrenceHelper2(arr, idx, target, 0);
    }

    private static int AllIndexOfOccurrenceHelper2(int[] arr, int idx, int target, int countOfIndex) {

        if(idx == arr.length){
            return countOfIndex;
        }

        if(arr[idx] == target){
            countOfIndex++;
        }
        return  AllIndexOfOccurrenceHelper2(arr, idx+1, target, countOfIndex);

    }
}
