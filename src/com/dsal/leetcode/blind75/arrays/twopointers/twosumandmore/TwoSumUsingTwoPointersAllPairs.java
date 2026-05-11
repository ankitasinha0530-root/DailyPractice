package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumUsingTwoPointersAllPairs {

/**
 You may assume that each input would have more than one solution, and you may not use the same element twice.
 Return Original Indices
    Input: nums = [2, 4, 5, 7, 11 ,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2, 4, 5, 7, 11 ,15};
        int target = 9;
        List<int[]> list = findIndexsOfTargetSumEleMultiple(nums, target);
        list.forEach(pair ->
                System.out.println(Arrays.toString(pair)));

    }

    private static List<int[]> findIndexsOfTargetSumEleMultiple(int[] nums, int target) {

        int i = 0;
        int j = nums.length-1;
        List<int[]> result = new ArrayList<>();

    //    make sure the Array is sorted to use 2 pointers

        while( i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result.add(new int[]{i, j});
                i++;
                j--;
            } else if (sum < target) {
                i++;
            }else {
                j--;
            }
        }

        return result;
    }
}
