package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.HashMap;
import java.util.Map;

public class TwoSumUsingHashMapCountPairs {

/**
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2, 11, 7, 15, 4, 5, 6, 3};
        int target = 9;
        int count = twoSumUsingHashMap(nums, target);
        System.out.println(count);

    }

    private static int twoSumUsingHashMap(int[] nums, int target) {
        // if the elements are not sorted and we don;t want to sort it
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int valueNeeded = target - nums[i];
            if(map.containsKey(valueNeeded)){
                count++;
            }
            map.put(nums[i], i);

        }

        return count;
    }
}
