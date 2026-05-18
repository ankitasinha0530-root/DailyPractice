package com.dsal.leetcode.blind75.arrays;

//https://www.youtube.com/watch?v=iXLMMbdjeNM&t=121s
//https://www.youtube.com/watch?v=4Ik1nCLjwcI

public class SearchElementInRotatedArray2 {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchElementInRotatedSortedArr(nums, 0));

        int[] nums1 = {2, 5};
        System.out.println(searchElementInRotatedSortedArr(nums1, 5));

        int[] nums2 = {5};
        System.out.println(searchElementInRotatedSortedArr(nums2, 2));

        int[] nums3 = {8, 9, 10, 11, 0, 1, 2 , 3, 4, 5, 6, 7 };
        System.out.println(searchElementInRotatedSortedArr(nums3, 6));

        System.out.println(searchElementInRotatedSortedArr(nums3, 11));

    }

    // Recursion method
    private static int searchElementInRotatedSortedArr(int[] nums, int target) {

        if(nums.length < 2 && target == nums[0]){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        // 1st find the minimum element index, that is the Pivot.
        while(left < right){

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]) { // it means left side of mid is sorted
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        int min_idx = left;
        if(nums[min_idx] == target){
            return min_idx;
        }

        if(min_idx == 0) { // if minimum index is equal to 0, then the array is not rotated
            left = 0;
            right = nums.length -1;
        } else if (target >= nums[0] && target <= nums[min_idx - 1]) { // if target element is between 0th index and min_idx - 1
            left = 0;
            right = min_idx -1 ;
        }else{  // if target element is NOT between 0th index and min_idx - 1
            left = min_idx;
            right = nums.length - 1;
        }

        while (left <= right){

            int mid = left + (right - left)/2;

            if(target == nums[mid]){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
