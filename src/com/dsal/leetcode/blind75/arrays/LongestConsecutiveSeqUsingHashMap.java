package com.dsal.leetcode.blind75.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSeqUsingHashMap {

    // https://www.youtube.com/watch?v=joIEdeOGqjQ
    // https://www.youtube.com/watch?v=LvbtUMdcgbw

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSeq(nums));

        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutiveSeq(nums1));
    }

    private static int longestConsecutiveSeq(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        int maxLength = 0;

        Map<Integer, Boolean> exploredMap = new HashMap<>();

        for (int num : nums) {
            exploredMap.put(num, false);
        }

        for (int num : nums) {

            int length = 1;
        //  Search for right elements in forward direction
            int next_num = num + 1;
            while (exploredMap.containsKey(next_num) && exploredMap.get(next_num) == Boolean.FALSE) {
                length += 1;
                exploredMap.put(next_num, Boolean.TRUE);

                next_num += 1; // move to next number
            }
            // Search for left elements in backward direction
            int prevNum = num - 1;
            while (exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)) {
                length += 1;
                exploredMap.put(prevNum, Boolean.TRUE);

                prevNum -= 1; // move to previous number
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

}
