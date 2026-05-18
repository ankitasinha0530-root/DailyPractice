package com.dsal.arrays.twopointers.twosumandmore;

import java.util.*;

public class TwoSumUsingHashMapAllPairs {

/**
 You may assume that each input would have more than one solution, and you may not use the same element twice.
 Return original Indices
    Input: nums = [2, 11, 7, 15, 4, 5], target = 9,
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

    public static void main(String[] args) {

        int[] nums = {2, 11, 7, 15, 4, 5};
        int target = 9;
        List<int[]> list = twoSumUsingHashMapMultiple(nums, target);

        list.forEach(pair ->
                System.out.println(Arrays.toString(pair)));

    }

    private static List<int[]> twoSumUsingHashMapMultiple(int[] nums, int target) {
        // if the elements are not sorted and we don;t want to sort it
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int valueNeeded = target - nums[i];
            if(map.containsKey(valueNeeded)){
                result.add(new int[]{map.get(valueNeeded), i});
            }
            map.put(nums[i], i);

        }

        return result;
    }
}
