package com.dsal.arrays.twopointers.twosumandmore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUsingHashMap {

/**
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] arr = twoSumUsingHashMap(nums, target);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));

    }

    private static int[] twoSumUsingHashMap(int[] nums, int target) {
        // if the elements are not sorted and we don;t want to sort it
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int valueNeeded = target - nums[i];
            if(map.containsKey(valueNeeded)){
                return new int[]{map.get(valueNeeded), i};
            }
            map.put(nums[i], i);

        }

        return new int[0];
    }
}
