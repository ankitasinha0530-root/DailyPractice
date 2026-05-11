package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); // 1. sort number
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n-2; i++) { // outer will  fix 1st number - n-k+1 = n-3+1 = n-2

            if (i > 0 && nums[i] < nums[i-1]){ // if two consecutive numbers are same then keep moving to next element until unique is found
                continue;
            }

            int left = i + 1; // since 1st element is fixed  above hence left will start from the element next to it
            int right = nums.length - 1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]){ // skip duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]){ // skip duplicates
                        right--;
                    }
                } else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
