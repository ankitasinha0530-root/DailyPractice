package com.dsal.leetcode.blind75.arrays;

//https://www.youtube.com/watch?v=iXLMMbdjeNM&t=121s
//https://www.youtube.com/watch?v=4Ik1nCLjwcI

public class SearchElementInRotatedArray {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchElementInRotatedSortedArrRecurr(nums, 0, 0, nums.length-1));

        int[] nums1 = {2, 5};
        System.out.println(searchElementInRotatedSortedArrRecurr(nums1, 5, 0 , nums1.length-1));

        int[] nums2 = {5};
        System.out.println(searchElementInRotatedSortedArrRecurr(nums2, 2, 0, nums2.length-1));

        int[] nums3 = {8, 9, 10, 11, 0, 1, 2 , 3, 4, 5, 6, 7 };
        System.out.println(searchElementInRotatedSortedArrRecurr(nums3, 6, 0, nums3.length-1));

        System.out.println(searchElementInRotatedSortedArrRecurr(nums3, 11, 0, nums3.length-1));

    }

    // Recursion method
    private static int searchElementInRotatedSortedArrRecurr(int[] nums, int target, int left, int right) {

        if(left > right){
            return -1;
        }
        // find middle element
        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid;
        }

        // check which side from the middle is sorted
        if(nums[mid] >= nums[left]){ // if true, means left side is sorted

            if(target >= nums[left] && target < nums[mid]){ // check if target is in left array
                return searchElementInRotatedSortedArrRecurr(nums, target, left, mid - 1);
            }else{
                return searchElementInRotatedSortedArrRecurr(nums, target, mid + 1, right);
            }
        }else { //  in else, means right side is sorted

            if(target >= nums[mid] && target <= nums[right]){ // check if target is in roght array
                return searchElementInRotatedSortedArrRecurr(nums, target, mid + 1, right);
            }else{
                return searchElementInRotatedSortedArrRecurr(nums, target, left, mid-1);
            }
        }



    }
}
