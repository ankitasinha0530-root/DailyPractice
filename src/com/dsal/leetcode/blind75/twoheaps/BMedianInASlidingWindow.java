package com.dsal.leetcode.blind75.twoheaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BMedianInASlidingWindow {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int[] arr, int k) {

        double[] result = new double[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= arr[i]) {
                maxHeap.add(arr[i]);
            } else {
                minHeap.add(arr[i]);
            }
            balanceHeap();
            // find Median,
            // slide window to right by 1
            // remove element which moved out of the window,
            // then balance again
            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    double median = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                    result[i - k + 1] = (double) median;
                } else {
                    result[i - k + 1] = (double) maxHeap.peek();
                }
                removeElement(arr, i, k);
                balanceHeap();
            }
        }

        return result;
    }

    public void balanceHeap() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void removeElement(int[] arr, int i, int k) {
        int removeNum = arr[i - k + 1];
        if (maxHeap.contains(removeNum)) {
            maxHeap.remove(removeNum);
        } else {
            minHeap.remove(removeNum);
        }
    }

    public static void main(String[] args) {

        BMedianInASlidingWindow medianOfAStreamSlidingWindow = new BMedianInASlidingWindow();

		double[] result0 =  medianOfAStreamSlidingWindow.findSlidingWindowMedian(new int[] {1, 3, 2, -2, 9, 6, -1, 7, 5, 12}, 3);
        System.out.print(" median result 1 = " + Arrays.toString(result0));

		System.out.println();
        double[] result1 = medianOfAStreamSlidingWindow.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print(" median result 1 = " + Arrays.toString(result1));

        System.out.println();
        double[] result2 = medianOfAStreamSlidingWindow.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print(" median result 2 = " + Arrays.toString(result2));

        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(medianOfAStreamSlidingWindow.findSlidingWindowMedian(nums1, 3)));
        // Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]

    }

}
/**
 Refer video = https://www.youtube.com/watch?v=dshWERdcAdg - for another solution of pep-coding

	Step1 = start a for loop for array and add the element in heap
		step 1a = re-balance the heap to keep the elements as needed
		step 1a : run step 1 and step 2 until the loop runs for k element
		step 1a : loop ran for k elements check(i-k+1 >= 0)
			step 1a.a : find median and add in result array
			step 1a.b : remove the first element
			step 1a.c : after removing element re-balance the heaps again
 Repeat all the above steps for further k size window until end of array is reached
 */
