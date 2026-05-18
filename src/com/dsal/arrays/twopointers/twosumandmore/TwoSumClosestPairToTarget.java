package com.dsal.arrays.twopointers.twosumandmore;

import java.util.Arrays;

public class TwoSumClosestPairToTarget {

    public static void main(String[] args) {

        int[] nums = {1, 4, 7, 10};

        System.out.println(Arrays.toString(closestPair(nums, 15)));
    }

    private static int[] closestPair(int[] nums, int target) {

        int i = 0;
        int j = nums.length-1;
        int closest = Integer.MAX_VALUE;

        int[] result = new int[2];

        while (i < j){

            int sum = nums[i] + nums[j];

            if(Math.abs(target - sum) < Math.abs(target - closest)){
                closest = sum;
                result[0] = nums[i];
                result[1] = nums[j];
            }
            if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
