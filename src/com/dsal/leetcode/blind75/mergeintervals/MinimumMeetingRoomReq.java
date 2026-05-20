package com.dsal.leetcode.blind75.mergeintervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumMeetingRoomReq {
    public static void main(String[] args) {


        // refer Video - https://www.youtube.com/watch?v=bgZmJiPfkYE
        // refer video = https://www.youtube.com/watch?v=s8oOsWGHIl4


        int[][] intervals = {{6, 7}, {2, 5}, {8, 12}}; // output = 1
        System.out.println(noOfMeetingRoomRequiredTwoPtr(intervals)); // min no.of meeting rooms required
        System.out.println(noOfMeetingRoomRequiredMinHeap(intervals));

        System.out.println();
        int[][] intervals1 = {{1, 4}, {2, 5}, {7, 9}}; // output = 2
        System.out.println(noOfMeetingRoomRequiredTwoPtr(intervals1));
        System.out.println(noOfMeetingRoomRequiredMinHeap(intervals1));

        System.out.println();
        int[][] intervals2 = {{0, 30}, {5, 10}, {15, 20}}; // output = 2
        System.out.println(noOfMeetingRoomRequiredTwoPtr(intervals2));
        System.out.println(noOfMeetingRoomRequiredMinHeap(intervals2));
    }

    // We have to focus on end time of the meeting

    private static int noOfMeetingRoomRequiredTwoPtr(int[][] intervals) {

        int n = intervals.length;
        int[] startIntervals = new int[n];
        int[] endIntervals = new int[n];
        for (int i = 0; i < n; i++) {
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
        }
        Arrays.sort(startIntervals);
        Arrays.sort(endIntervals);

        int room = 0;
        int endPointer = 0;

        for (int i = 0; i < n; i++) {
            if (startIntervals[i] < endIntervals[endPointer]) { // check if meeting started before the 1st meeting ended
                room++;       // if yes then the meeting would require new room
            } else {
                endPointer++; // else next meeting can continue in same room.
            }
        }
        return room;
    }

    private static int noOfMeetingRoomRequiredMinHeap(int[][] intervals) {

        int minMeetingRooms = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparing(i -> i[1]));

        for (int[] interval : intervals) {
            while (!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) {  // remove all meetings that have ended before this iteration meeting start from minHeap
                minHeap.poll(); // if not overlapping then we dont need more rooms, we can have multiple meetings in 1 single room
            }
            minHeap.offer(interval); // add the current meeting into the minHeap
            minMeetingRooms = Math.max(minMeetingRooms, minHeap.size()); // at every interval calculate the min meeting rooms
        }


        return minMeetingRooms;
    }
}
