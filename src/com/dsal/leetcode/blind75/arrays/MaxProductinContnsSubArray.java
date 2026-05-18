package com.dsal.leetcode.blind75.arrays;

public class MaxProductinContnsSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] arr1 = {5, 4, -1, 7, 8};

        int[] arr2 = {-2, 0, -1};

        int[] arr3 = {2, 3, -2, 4};

        System.out.println(maxProductInSubArray(arr));
        System.out.println(maxProductInSubArray(arr1));
        System.out.println(maxProductInSubArray(arr2));
        System.out.println(maxProductInSubArray(arr3));

    }

    private static int maxProductInSubArray(int[] arr) {

        int n = arr.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int maxSoFar = arr[0];

        for (int i = 0; i < n; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct; // if 0, then assign 1
            rightProduct = rightProduct == 0 ? 1 : rightProduct; // if 0, then assign 1

            leftProduct *= arr[i]; // keep on multiplying from left side
            rightProduct *= arr[n - 1 - i]; // keep on multiplying from right side

            maxSoFar = Math.max(maxSoFar, Math.max(leftProduct, rightProduct));

        }
        return maxSoFar;
    }

}

/**
 Steps : create 3 variable

 leftProduct = 1;  - start multiplying from left side
 rightProduct = 1; - start multiplying from right side

 maxSoFar = arr[0] - 0th element
 Inside Loop
 if leftProduct is 0 then assign it with 1
 if rightProduct = 0 then assign it with 1

 keep on multiplying from left side
 keep on multiplying from right side

 take max for left or right product

 from above compare with maxSoFar and extract the max

 This max is our answer
 */




