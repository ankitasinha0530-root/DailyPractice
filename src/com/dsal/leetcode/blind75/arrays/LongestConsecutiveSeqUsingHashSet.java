package com.dsal.leetcode.blind75.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSeqUsingHashSet {

    // https://www.youtube.com/watch?v=joIEdeOGqjQ
    //

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSeq(nums));

        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSeq(nums1));
    }

    private static int longestConsecutiveSeq(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
//        Set<Integer> set = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.toSet());

        for(int num : set){ // loop through Set to remove the duplicates and not through actual nums array

            if(!(set.contains(num - 1))){
                int next_num = num + 1;
                int length = 1;

                while(set.contains(next_num)){
                    next_num += 1;
                    length += 1;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

}
