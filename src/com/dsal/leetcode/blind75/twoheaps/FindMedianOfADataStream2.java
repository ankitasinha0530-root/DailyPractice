package com.dsal.leetcode.blind75.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianOfADataStream2 {

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

        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        System.out.println("before balance = maxHeap  = " + maxHeap + ", minHeap  = " + minHeap);

        // Balance maxHeap and minHeap size

        if(minHeap.size() < maxHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
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
