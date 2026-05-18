package com.dsal.leetcode.blind75.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));

        int[] nums1 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums1)));

        int[] nums2 = {3, 4, 6, 1, 2};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums2)));

    }

    private static int[] productOfArrayExceptSelf(int[] nums) {

        int n = nums.length;
        if(n < 2){
            return nums;
        }

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        // Extract product of the Array left to ith position
        leftProduct[0] = 1; // since we do not have anything to the left of 0th position
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        rightProduct[n-1] = 1; // since we do not have anything on the right of the last element in an array
        for (int j = n-2; j >=0 ; j--) {
            rightProduct[j] = rightProduct[j+1] * nums[j+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
            
        }
        return nums;
    }

}
