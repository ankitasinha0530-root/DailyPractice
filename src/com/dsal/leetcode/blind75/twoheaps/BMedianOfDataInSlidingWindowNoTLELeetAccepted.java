package com.dsal.leetcode.blind75.twoheaps;

import java.util.*;

public class BMedianOfDataInSlidingWindowNoTLELeetAccepted {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static Map<Integer, Integer> delayedDel = new HashMap<>();
    static int minHeapSize;
    static int maxHeapSize;

    public static void main(String[] args) {

//        int[] nums = {1, 3, 5, 12, 11, 12, 11};
//        System.out.println(Arrays.toString(meadianOfStreamOfDataInAWindow(nums, 3)));

        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(meadianOfStreamOfDataInAWindow(nums1, 3)));
        // Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]

    }

    // this method will decrease the time for very large data no long execution
    public static double[] meadianOfStreamOfDataInAWindow(int[] nums, int k) {

        double[] res = new double[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {

            add(nums[i]);

            if(i >= k){
                remove(nums[i - k]); // start removing from 1st element
            }

            if(i >= k - 1){
                res[i-k+1] = findMedian();
            }

        }
        return res;
    }

    public static double findMedian(){
        if(maxHeapSize == minHeapSize){
            return (maxHeap.peek()/2.0 + minHeap.peek()/2.0);
        }
        return (double) maxHeap.peek();
    }

    public static void add(int num){

        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
            maxHeapSize++;
        }else{
            minHeap.offer(num);
            minHeapSize++;
        }
        balance();

    }

    public static void balance(){
        prune(maxHeap);
        prune(minHeap);

        if(maxHeapSize > minHeapSize + 1){
            minHeap.offer(maxHeap.poll());
            minHeapSize++;
            maxHeapSize--;
            prune(maxHeap);
        }else if (maxHeapSize < minHeapSize){
            maxHeap.offer(minHeap.poll());
            maxHeapSize++;
            minHeapSize--;
            prune(minHeap);

        }
    }

    public static void remove(int num){
        delayedDel.put(num, delayedDel.getOrDefault(num, 0) + 1);

        if(!maxHeap.isEmpty() && num <= maxHeap.peek()){
            maxHeapSize--;
            if(num == maxHeap.peek()){
                prune(maxHeap);
            }
        }else{
            minHeapSize--;
            if(!minHeap.isEmpty() && num == minHeap.peek()){
                prune(minHeap);
            }
        }
        balance();
    }

    public static void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int topOfHeap = heap.peek();

            if (!delayedDel.containsKey(topOfHeap)) {
                break;
            }

            int count = delayedDel.get(topOfHeap);
            if (count == 1) {
                delayedDel.remove(topOfHeap);
            } else {
                delayedDel.put(topOfHeap, count - 1);
            }
            heap.poll();
        }
    }
}


/**
 Step1 = start iterating through the array

 Step2 = for every new element decide where to add:
         - if maxHeap is empty
           OR current number <= maxHeap.peek()
           -> add into maxHeap

         - else
           -> add into minHeap

         Reason:
         - maxHeap stores smaller half of numbers
         - minHeap stores larger half of numbers

 Step3 = after adding, balance both heaps so that:
         - maxHeap has either same number of elements as minHeap
         - or only one extra element than minHeap

         Conditions:
         - if maxHeapSize > minHeapSize + 1
           -> move top element from maxHeap to minHeap

         - if maxHeapSize < minHeapSize
           -> move top element from minHeap to maxHeap

 Step4 = once first k elements are processed
         (i >= k - 1)

         -> find median

         - if both heaps have same size
           median = average of both heap tops

         - else
           median = top of maxHeap

 Step5 = when sliding window moves ahead
         remove the element going out of window
         nums[i-k]

 Step6 = do lazy deletion instead of direct removal:
         - store element count in delayedDel map

 Step7 = decide from which heap element belongs:

         - if number <= maxHeap.peek()
           -> logically remove from maxHeap

         - else
           -> logically remove from minHeap

 Step8 = if removed element is currently at heap top
         prune the heap

         prune means:
         keep removing top elements while they are marked
         inside delayedDel map

 Step9 = after removal rebalance heaps again

 Step10 = repeat all steps until array traversal ends
*/























