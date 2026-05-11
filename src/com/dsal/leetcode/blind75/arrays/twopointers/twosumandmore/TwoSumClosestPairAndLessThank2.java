package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.Arrays;

public class TwoSumClosestPairAndLessThank2 {

    public static void main(String[] args) {

        int[] nums = {34, 23 , 1, 24, 75, 33, 54, 8};

        System.out.println(Arrays.toString(twoSumValueClosestAndLessThank(nums, 60)));
    }

    private static int[] twoSumValueClosestAndLessThank(int[] nums, int target) {
         int[] result = new int[2];
         int i = 0;
         int j = nums.length-1;
         int max = -1;

         while(i < j){

             int sum = nums[i] + nums[j];

             if(sum < target && sum > max){
                 max = sum;
                 result[0] = nums[i];
                 result[1] = nums[j];
                 i++;
             }else{
                 j--;
             }
         }
         return result;
    }
}
