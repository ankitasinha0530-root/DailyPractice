package com.dsal.arrays.twopointers.twosumandmore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumSolver {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};

        System.out.println(kSum(nums, 0, 3));
        System.out.println(kSum(nums, 0, 4));
    }

    private static List<List<Integer>> kSum(int[] nums, int target, int k) {

        Arrays.sort(nums);
        return kSumHelper(nums, 0, target, k);
    }

    private static List<List<Integer>> kSumHelper(int[] nums, int start, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if(k == 2){

            int left = start;
            int right = nums.length - 1;

            while(left < right){

                int sum = nums[left] + nums[right];

                if(sum == target){
                    result.add(List.of(nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(sum < target){
                    left++;
                }else {
                    right--;
                }

            }
            return result; // return the result after while loop ends inside (k==2) condition block before closing condition (k==2)
        }
        for (int i = start; i < n-k+1; i++) {

            if(i > start && nums[i] == nums[i-1]){
                i++;
            }
            List<List<Integer>> subResult = kSumHelper(nums, i+1, target - nums[i], k-1);

            for(List<Integer> subSet : subResult){ // Extract the list of integer from result, repeat below steps for all the element
                List<Integer> current = new ArrayList<>(); // create a new array list
                current.add(nums[i]); // in the new list add ith value
                current.addAll(subSet); // and then append the subset extracted from the result to the current
                result.add(current); // add this final current list to the result which is a list of list
            }

        }
        return result;

    }

}
