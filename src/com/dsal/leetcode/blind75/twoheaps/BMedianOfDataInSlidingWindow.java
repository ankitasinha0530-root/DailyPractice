package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BMedianOfDataInSlidingWindow {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 12, 11, 12, 11};
        System.out.println(Arrays.toString(meadianOfStreamOfDataInAWindow(nums, 3)));

    }

    // this method will give Time Limit Exceeded in leet Code for very large data execution
    // 43 out of 45 tests executed on Leet Code
    public static double[] meadianOfStreamOfDataInAWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        int i = 0; // [1,3,-1,-3,5,3,6,7] and k = 3;
        for (; i < k - 1; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            balance();
        }
        for (i = k - 1; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            balance();
            // Find Median
            res[i-k+1] = maxHeap.size() == minHeap.size() ? maxHeap.peek()/2.0 + minHeap.peek()/2.0 // dividing 1st and then adding this is to avoid overflows
                    : (double) maxHeap.peek();
            int removeNum = nums[i-k+1]; //remove elements from start
            if(removeNum <= maxHeap.peek()){
                maxHeap.remove(removeNum);
            }else{
                minHeap.remove(removeNum);
            }
            balance();
        }
        return res;
    }

    public static void balance(){
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

}
