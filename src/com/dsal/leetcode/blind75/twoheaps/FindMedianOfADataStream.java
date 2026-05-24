package com.dsal.leetcode.blind75.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianOfADataStream {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max at top desc
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min at top ascending default

    public static void main (String[] args){

        addNumber(2); addNumber(8); addNumber(10); addNumber(5);
        System.out.println("Median 1 : " + findMedian());

        addNumber(4);
        System.out.println("Median 2 : " + findMedian());

        addNumber(6); addNumber(11); addNumber(3); addNumber(1);
        System.out.println("Median 3 : " + findMedian());

        addNumber(12);
        System.out.println("Median 4 : " + findMedian());

    }

    public static void addNumber(int num){

        // 1st add to minHeap
        maxHeap.offer(num);

        // then add the top element of maxHeap to minHeap, as it would be the largest in maxHeap
        minHeap.offer(maxHeap.poll());

        // balance
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        System.out.println("maxHeap  = " + maxHeap + ", minHeap  = " + minHeap);

    }

    public static double findMedian(){
        double res = -1;
        if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            if (maxHeap.size() == minHeap.size()) {
                res =  (maxHeap.peek() + minHeap.peek()) / 2.0;
            }else{
                res = maxHeap.peek();
            }
        }
        return res;
    }
}

/**
Steps : for addNum method
    1. 1st add the num to maxHeap
    2. then move the top number of maxHeap to minHeap
    3. then balance the size of maxHeap and minHeap
        if (minHeap.size() > maxHeap.size())
            then move the top element from minHeap to maxHeap

 */
