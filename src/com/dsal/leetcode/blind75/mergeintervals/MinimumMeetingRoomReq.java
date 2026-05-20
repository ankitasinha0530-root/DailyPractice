package com.dsal.leetcode.blind75.mergeintervals;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumMeetingRoomReq {
    public static void main(String[] args) {


        // refer Video - https://www.youtube.com/watch?v=bgZmJiPfkYE
        // refer video = https://www.youtube.com/watch?v=s8oOsWGHIl4


        int[][] intervals = {{6, 7}, {2, 5}, {8, 12}}; // output = 1
        System.out.println(noOfMeetingRoomRequired(intervals)); // min no.of meeting rooms required

        int[][] intervals1 = {{1, 4}, {2, 5}, {7, 9}}; // output = 2
        System.out.println(noOfMeetingRoomRequired(intervals1));

        int[][] intervals2 = {{0, 30}, {5, 10}, {15, 20}}; // output = 2
        System.out.println(noOfMeetingRoomRequired(intervals2));
    }

    // We have to focus on end time of the meeting

    private static int noOfMeetingRoomRequired(int[][] intervals) {

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
            if(startIntervals[i] < endIntervals[endPointer]){ // check if meeting started before the 1st meeting ended
                room++;       // if yes then the meeting would require new room
            }else {
                endPointer++; // else next meeting can continue in same room.
            }
        }
        return room;
    }
}
