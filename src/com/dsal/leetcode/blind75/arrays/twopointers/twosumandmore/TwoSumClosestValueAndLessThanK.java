package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;


import java.util.Arrays;

public class TwoSumClosestValueAndLessThanK {

    public static void main(String[] args) {

        int[] nums = {34, 23 , 1, 24, 75, 33, 54, 8};

        System.out.println(twoSumValueClosestAndLessThanK(nums, 60));
    }

    private static int twoSumValueClosestAndLessThanK(int[] nums, int target) {

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int i = 0;
        int j = nums.length - 1;
        int max = -1;

        while(i < j){

            int sum = nums[i] + nums[j];

            if(sum < target){
                max = Math.max(sum, max);
                i++;
            }else{
                j--;
            }
        }

         return max;
    }
}
