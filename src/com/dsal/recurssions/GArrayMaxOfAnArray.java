package com.dsal.recurssions;

public class GArrayMaxOfAnArray {

    public static void main(String[] args){

        int[] arr = {7, 3, 2, 6, 4, 11, 9};

        System.out.println("Max = " + findMaxInAnArray(arr, 0));

        System.out.println("Max 2 = " + findMaxInAnArray2(arr, 0));

        System.out.println("Max 3 = " + findMaxInAnArray3(arr, 0));
    }

    private static int findMaxInAnArray(int[] arr, int idx) {

        int max = Integer.MIN_VALUE;
        return findMaxInAnArrayHelper(arr, idx, max);

    }

    private static int findMaxInAnArrayHelper(int[] arr, int idx, int max) {

        if(idx == arr.length -1){
            return max;
        }

        max = Math.max(max, arr[idx]);
        return findMaxInAnArrayHelper(arr, idx+1, max);
    }

    private static int findMaxInAnArray2(int[] arr, int idx) {

        int max = Integer.MIN_VALUE;
        return findMaxInAnArrayHelper2(arr, idx, max);

    }

    private static int findMaxInAnArrayHelper2(int[] arr, int idx, int max) {

        if(idx == arr.length -1){
            return max;
        }

        max = Math.max(max, arr[idx]);
        int maxSoFar = findMaxInAnArrayHelper(arr, idx+1, max);

        return maxSoFar;
    }

    private static int findMaxInAnArray3(int[] arr, int idx) {

        if(idx == arr.length -1){
            return arr[idx];
        }

        int maxSoFar = findMaxInAnArray2(arr, idx+1);

        if(maxSoFar < arr[idx]){
            return arr[idx];
        }else{
            return maxSoFar;
        }



    }
}
