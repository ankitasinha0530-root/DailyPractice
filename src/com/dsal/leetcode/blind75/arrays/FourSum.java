package com.dsal.leetcode.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) { // n-k+1 = n-4+1 = n-3

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length - 2; j++) {

                if(j > i+1 && nums[j] == nums[i=j-1]){
                    continue;
                }

                int left = j+1;
                int right = nums.length - 1;

                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == 0){
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    } else if (sum < 0) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
