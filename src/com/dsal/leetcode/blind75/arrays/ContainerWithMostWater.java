package com.dsal.leetcode.blind75.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater(heights));

    }
// https://www.youtube.com/watch?v=Y_4_or0Sc7I
    // https://www.youtube.com/watch?v=w7ftYsZtIbs
    private static int containerWithMostWater(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right){
            int h = Math.min(heights[left], heights[right]); // for a container to make always take smaller height of the two, to calculate the area
            int w = right - left; // distance between these two points
            int area = w * h;
            maxArea = Math.max(area, maxArea);
            if(heights[left] < heights[right]){ // we need to keep whichever is bigger of left and right height and move next of the smaller one
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
