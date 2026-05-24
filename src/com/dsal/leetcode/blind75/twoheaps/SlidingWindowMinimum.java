package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMinimum {

    public static void main(String[] args) {

        int[] nums = {10, 7, 4, 6, 9, 8, 5};
        System.out.println("Min Number : " + Arrays.toString(slindingWindowMinimum(nums, 3)));

        System.out.println("Min Number : " + Arrays.toString(slindingWindowMinimum(nums, 5)));

        System.out.println("Min Number : " + Arrays.toString(slindingWindowMinimum(nums, 2)));

    }

    private static int[] slindingWindowMinimum(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {

            minHeap.offer(nums[i]);

            if(i >= k - 1){
                result[i-k+1] = minHeap.peek();
                minHeap.remove(nums[i-k+1]);
            }
        }
        return result;

    }

}
