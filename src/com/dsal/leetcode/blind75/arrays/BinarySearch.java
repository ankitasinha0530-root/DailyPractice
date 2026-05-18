package com.dsal.leetcode.blind75.arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        System.out.println(binarySearchSolve(nums, 9));
        System.out.println(binarySearchSolve(nums, 2));

        int[] nums1 = {2, 5};
        System.out.println(binarySearchSolve(nums1, 5));

        int[] nums2 = {5};
        System.out.println(binarySearchSolve(nums2, 5));

    }

    private static int binarySearchSolve(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int middle = low + (high - low)/2;
            if( target == nums[middle] ){
                return middle;
            } else if (target < nums[middle]) {
                high = middle -1;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }

}
