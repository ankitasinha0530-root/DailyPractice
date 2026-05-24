package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximumHeap {

    public static void main(String[] args) {

        int[] nums = {10, 7, 4, 6, 9, 8, 5};
        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 3)));

        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 5)));

        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 2)));

    }

    private static int[] slindingWindowMaximum(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);

            if( i >= k - 1){
                result[i-k+1] = maxHeap.peek();
                maxHeap.remove(nums[i - k + 1]);
            }

        }
        return result;

    }

}
