package com.dsal.leetcode.blind75.mergeintervals;

public class CouldAttendAllMeeting {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        System.out.println(canAttendAllMeetings(intervals));

        int[][] intervals1 = {{1, 3}, {6, 8}, {2, 5}};
        System.out.println(canAttendAllMeetings(intervals1));
    }

    private static boolean canAttendAllMeetings(int[][] intervals) {

        for (int i = 1; i < intervals.length; i++){

            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }

}
