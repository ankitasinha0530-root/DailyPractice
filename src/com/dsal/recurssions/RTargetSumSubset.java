package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class RTargetSumSubset {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60 };

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        printSetsToTargetSum(arr, 0, list, 0, 60, result);
        System.out.println(result);
    }

    private static void printSetsToTargetSum(int[] arr, int idx, List<Integer> list, int sum, int target, List<List<Integer>> result) {

        if (idx >= arr.length - 1){
            if(sum == target){
                System.out.println(list);
                result.add(new ArrayList<>(list)); // always create new list while adding in final result.
            }
            return;
        }
        list.add(arr[idx]); // when element is included
        printSetsToTargetSum(arr, idx+1, list, sum + arr[idx], target, result);

        list.removeLast(); // when element is excluded
        printSetsToTargetSum(arr, idx+1, list, sum, target, result);
    }

}
