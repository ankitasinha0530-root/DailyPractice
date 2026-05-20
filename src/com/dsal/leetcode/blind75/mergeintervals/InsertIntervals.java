package com.dsal.leetcode.blind75.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=wCBtjZxw1xY&t=550s

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8}; //Output: {{1,2},{3,10},{12,16}}
        //	Explanation : Because the new interval {4,8} overlaps with {3,5},{6,7},{8,10}.
        System.out.println(Arrays.deepToString(insertIntervals(intervals, newInterval)));
        System.out.println(Arrays.deepToString(insertIntervals2(intervals, newInterval)));
        System.out.println();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {8, 10};
        System.out.println(Arrays.deepToString(insertIntervals(intervals1, newInterval1)));
        System.out.println(Arrays.deepToString(insertIntervals2(intervals1, newInterval1)));
    }

    private static int[][] insertIntervals(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int[] interval = intervals[i];
/** if the end of newInterval is less than start of 1st interval
 if start of 1st interval is greater then end of new interval*/
            if(newInterval[1] < interval[0]){
                result.add(newInterval);
                while (i < intervals.length){
                    result.add(intervals[i]);
                    i++;
                }
                return result.toArray(new int[result.size()][2]);
/** check if interval end is less than start of new interval
 it means we cannot merge with interval
 and it will go next to it and move on with checking with other elements  */
            }else if (newInterval[0] > interval[1]){
                result.add(interval);
            }else{
                newInterval[1] = Math.max(interval[1], newInterval[1]);
                newInterval[0] = Math.min(interval[0], newInterval[0]);
            }

        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }

    private static int[][] insertIntervals2(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

/** if the end of newInterval is less than start of 1st interval
 if start of 1st interval is greater then end of new interval*/
            if(intervals[i][0] > newInterval[1]){
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[i]);
                }
                return result.toArray(new int[result.size()][2]);
/** check if interval end is less than start of new interval
 it means we cannot merge with interval
 and it will go next to it and move on with checking with other elements  */
            }else if (intervals[i][1] < newInterval[0]){
                result.add(intervals[i]);
            }else{
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            }

        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }

    // Later understand
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        int start = Math.min(i < intervals.length ? intervals[i][0] : Integer.MAX_VALUE, newInterval[0]);
        int prevEnd = 0;
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            prevEnd = intervals[i][1];
            i++;
        }
        int end = Math.max(newInterval[1], prevEnd);
        res.add(new int[] {start, end});
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(int[][]::new);
    }
}
