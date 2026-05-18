package com.dsal.leetcode.blind75.arrays;

// https://www.youtube.com/watch?v=H2U24n4bcQQ

public class FindMinmInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMinmInaRotatedSortedArr(nums));

        int[] nums1 = {2, 5};
        System.out.println(findMinmInaRotatedSortedArr(nums1));

        int[] nums2 = {5};
        System.out.println(findMinmInaRotatedSortedArr(nums2));

    }

    private static int findMinmInaRotatedSortedArr(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right){

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }

        }
        return nums[left];

    }

}
