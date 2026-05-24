package com.dsal.leetcode.blind75.twoheaps;

import java.util.PriorityQueue;
// https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/
public class ConnectNRopesWithMinmCost {

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 8, 6, 9,};
        System.out.println("Highest Number : " + connectNRopesWithMinmCost(nums));
    }

    private static int connectNRopesWithMinmCost(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);
        }
        int finalCost = 0;
        while(minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            int sum = first + second;
            finalCost += sum;
            minHeap.offer(sum);
        }
        return finalCost;
    }

}


/**
 * We can only add two ropes at a time
 * the sum of the two rows will be the cost of joining two ropes
 * Eg. 2, 6, 5
 * sum = 2+ 6 = 8, 8+5 = 13
 * Cost = 8 + 13 = 21 certailnly this is not the minm
 *
 * sum = 2+5 = 7, 7+6 = 13 , t take the sum of minm first
 * Min Cost  = 7 + 13 = 20
 */
