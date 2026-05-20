package com.dsal.leetcode.blind75.mergeintervals;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals =  {{1,2}, {6,8}, {2,5}};

        int[][] result = mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(result));

        int[][] intervals1 =  {{1,4}, {4,5}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals1)));

        int[][] intervals2 =  {{2,6}, {1,3}, {8, 10}, {7, 9}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals2)));
        System.out.println();
        System.out.println("Merge Interval 2 output");
        System.out.println(Arrays.deepToString(mergeIntervals2(intervals)));
        System.out.println(Arrays.deepToString(mergeIntervals2(intervals1)));
        System.out.println(Arrays.deepToString(mergeIntervals2(intervals2)));

    }

    public static int[][] mergeIntervals2(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if(next[0] <= newInterval[1]){
                newInterval[1] = Math.max(next[1], newInterval[1]);
                newInterval[0] = Math.min(next[0], newInterval[0]);
            }else{
                result.add(newInterval);
                newInterval = intervals[i];
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];

        for (int[] interval : intervals) {
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else{
                result.add(newInterval);
                newInterval = interval;
            }

        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}