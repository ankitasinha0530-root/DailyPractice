package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthHighestNumber {

    public static void main(String[] args) {

        int[] nums = {10, 7, 4, 6, 9, 8, 5};
        System.out.println("Highest Number : " + kthHighestNumber(nums, 3));
        System.out.println("Highest Number : " + kthHighestNumber(nums, 5));
        System.out.println("Highest Number : " + kthHighestNumber(nums, 2));
        System.out.println();
        System.out.println("Highest Number : " + kthHighestNumber2(nums, 3));
        System.out.println("Highest Number : " + kthHighestNumber2(nums, 5));
        System.out.println("Highest Number : " + kthHighestNumber2(nums, 2));

    }

    private static int kthHighestNumber(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b - a);

        for (int num : nums){
            maxHeap.offer(num);
        }
        int i = 0;
        while (i < k - 1){
            maxHeap.poll();
            i++;
        }
        return maxHeap.poll();
    }

    private static int kthHighestNumber2(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }


}
