package com.dsal.leetcode.blind75.arrays;
/**
Use Kadane’s Algorithm.
Idea
At each index, decide whether to:
    1. extend the current subarray, or
    2. start a new subarray from the current element.

    We check if the sum of all the previous element is less than the current element,
    Then ignore the previous sum and start a new Subarray from that element
*/
public class  MaxSumInContinsSubArray{

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumInContinsSubArray(nums));
        System.out.println(maxSumInContinsSubArray2(nums));

        int[] nums1 = {5,4,-1,7,8};
        System.out.println(maxSumInContinsSubArray(nums1));
        System.out.println(maxSumInContinsSubArray2(nums1));

        int[] nums2 = {1};
        System.out.println(maxSumInContinsSubArray(nums2));
        System.out.println(maxSumInContinsSubArray2(nums2));
    }

    private static int maxSumInContinsSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);

        }
        return maxSoFar;
    }

    private static int maxSumInContinsSubArray2(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax += nums[i];
            if(currentMax < nums[i]){
                currentMax = nums[i];
            }
            if(maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
        }
        return maxSoFar;
    }
}
