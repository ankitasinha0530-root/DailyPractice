package com.dsal.leetcode.blind75.twoheaps;

import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static void main(String[] args) {

        int[] nums = {10, 7, 4, 6, 9, 8, 5};
        System.out.println("Smallest Number : " + kthSmallestNumber(nums, 3));

        System.out.println("Smallest Number : " + kthSmallestNumber(nums, 5));

        System.out.println("Smallest Number : " + kthSmallestNumber(nums, 2));

    }

    private static int kthSmallestNumber(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums){
            minHeap.offer(num);
        }

        int i = 0;

        while(i < k){
            minHeap.poll();
            i++;
        }
        return minHeap.poll();
    }

}
