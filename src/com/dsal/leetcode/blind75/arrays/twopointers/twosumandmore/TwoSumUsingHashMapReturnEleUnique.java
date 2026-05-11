package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.*;

public class TwoSumUsingHashMapReturnEleUnique {

/**
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 4, 3};
        int target = 5;
        Set<List<Integer>> result = twoSumUsingHashMap(nums, target);
        System.out.println(result);
    //    Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static Set<List<Integer>> twoSumUsingHashMap(int[] nums, int target) {
        // if the elements are not sorted and we don;t want to sort it

        Set<Integer> seen = new HashSet<>();

        Set<List<Integer>> result = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if(seen.contains(complement)){
        // This step is to make sure that for each pair minimum number is visible first
                List<Integer> pair = Arrays.asList(
                        Math.min(complement, num),
                        Math.max(complement, num));
                result.add(pair);
            }
            seen.add(num);
        }

        return result;
    }
}
