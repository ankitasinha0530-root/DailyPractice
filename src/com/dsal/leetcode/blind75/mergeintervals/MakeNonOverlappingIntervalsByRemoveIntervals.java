package com.dsal.leetcode.blind75.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

// https://www.youtube.com/watch?v=XsrJgwGlRoc&t=1s

public class MakeNonOverlappingIntervalsByRemoveIntervals {

    /**
     There are two ways to solve this problem,
        equal elements are not considered as overlapping
        eg {1, 2} {2, 4} -- this is not overlapping, even though end of previous and start of next interval is same
         1. directly count the overlapping elements which needs to be removed and directly return count;
         2. count the non-overlapping elements which we want to keep and then return "intervals.length - count"
     */
    public static void main(String[] args) {

        // Here we do not consider equals as overlapping intervals..

        int[][] intervals =  {{1,2}, {2, 3}, {3, 4}, {1, 3}};
        int result = countOfIntervalRemovedToMakeNonOverlappingIntrval(intervals);
        System.out.println(result);
        System.out.println(countOfIntervalRemovedToMakeNonOverlappingIntrval2(intervals));

        int[][] intervals1 =  {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(countOfIntervalRemovedToMakeNonOverlappingIntrval(intervals1));
        System.out.println(countOfIntervalRemovedToMakeNonOverlappingIntrval2(intervals1));

        int[][] intervals2 =  {{1, 2}, {2,3}};
        System.out.println(countOfIntervalRemovedToMakeNonOverlappingIntrval(intervals2));
        System.out.println(countOfIntervalRemovedToMakeNonOverlappingIntrval2(intervals2));

    }

    /**
     There are two ways to solve this problem,
         1. directly count the overlapping elements which needs to be removed and directly return count;
            -->  sort the intervals based on 0th position
            -->  pick the 1st position element to start with not the 0th element
            -->  Check if the ith (1st) position element's start interval is less than i-1 position end interval
                    eg . interval[i][0] < intervals[i-1][1] then skip the next interval
                        (Not that if the above condition equals we are not considering then as overlapping
                            eg if 1st interval ends at 2 and the next interval starts at 2, they are not overlapping)
            -->  when skipping take the minimum of end interval of both intervals, as we pick the intervals which ends early
                    then do intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
     */

    private static int countOfIntervalRemovedToMakeNonOverlappingIntrval(int[][] intervals) {

        int count = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // remove overlapped intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]); // when skipping take the minm of end interval of both intervals
                count++;
            }
        }
        return count;
    }

    /** we will keep the count of Non-overlapping intervals
        --> sort the intervals based on the end interval
        --> initialize count with 1, coz at the end atlst one element will come as non overlapping
        -->

     */
    private static int countOfIntervalRemovedToMakeNonOverlappingIntrval2(int[][] intervals) {

        int count = 1;

        Arrays.sort(intervals, Comparator.comparing(i -> i[1]));
        // or Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int previous_intervals = 0;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= intervals[previous_intervals][1]){
                previous_intervals = i;
                count++;
            }
        }
        return intervals.length - count;
    }
}
