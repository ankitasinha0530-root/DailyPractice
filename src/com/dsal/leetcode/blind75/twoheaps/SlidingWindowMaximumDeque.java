package com.dsal.leetcode.blind75.twoheaps;

import java.net.http.WebSocket;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximumDeque {

    public static void main(String[] args) {

        int[] nums = {10, 7, 4, 6, 9, 8, 5};
        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 3)));
        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 5)));
        System.out.println("Max Number : " + Arrays.toString(slindingWindowMaximum(nums, 2)));

    }

    private static int[] slindingWindowMaximum(int[] nums, int k) {

        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int wStart = 0;
        Deque<Integer> dequeWindow = new ArrayDeque<>();

        for (int wEnd = 0; wEnd < nums.length; wEnd++) {

            while(!dequeWindow.isEmpty() && dequeWindow.peekLast() < nums[wEnd]){
                dequeWindow.removeLast();
            }
            dequeWindow.add(nums[wEnd]);

            if(wEnd >= k - 1){
                result[wStart] = dequeWindow.peekFirst();

                if(dequeWindow.peekFirst() == nums[wStart]){
                    dequeWindow.removeFirst();
                }
                wStart++;
            }
        }
        return result;
    }

}
