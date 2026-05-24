package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKMaxCountFrequentNumber {

    public static void main(String[] args) {

//		Map.Entry<Integer, Integer> == interface in Java provides certain methods to access the entry in the Map.
//		By gaining access to the entry of the Map we can easily manipulate them.
//		Map.Entry is a generic and is defined in the java.util package.

        System.out.println("Elements 1 = " + Arrays.toString(topKMaxCountFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 3)));
        System.out.println();
        System.out.println("Elements 2 = " + Arrays.toString(topKMaxCountFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2)));

    }

    private static int[] topKMaxCountFrequentNumbers(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int num : nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }
        System.out.println(freqCount);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            System.out.println(minHeap);
        }
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().getKey();
        }
        return result;
    }
}
