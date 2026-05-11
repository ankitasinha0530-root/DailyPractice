package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

public class TwoSumUsingTwoPointersCountAllPairs {

/**
 You may assume that each input would have more than one solution, and you may not use the same element twice.
 Return Original Indices
    Input: nums = [2, 4, 5, 7, 11 ,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 6, 7, 11 ,15};
        int target = 9;
        int count = findIndexsOfTargetSumEleMultiple(nums, target);
        System.out.println(count);

    }

    private static int findIndexsOfTargetSumEleMultiple(int[] nums, int target) {

        int i = 0;
        int j = nums.length-1;
        int count = 0;


    //    make sure the Array is sorted to use 2 pointers

        while( i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                count++;
                i++;
                j--;
            } else if (sum < target) {
                i++;
            }else {
                j--;
            }
        }

        return count;
    }
}
