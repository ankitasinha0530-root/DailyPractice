package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.Arrays;

public class TwoSumUsingTwoPointersReturnEle {

/**
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] arr = findIndexsOfTargetSumEle(nums, target);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static int[] findIndexsOfTargetSumEle(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while(i < j){
            int sum = nums[i] + nums[j];

            if(sum == target){
                return new int[]{nums[i], nums[j]};
            }else if(sum < target ){
                i++;
            }else{
                j--;
            }
        }

        return new int[]{0, 0};
    }
}
