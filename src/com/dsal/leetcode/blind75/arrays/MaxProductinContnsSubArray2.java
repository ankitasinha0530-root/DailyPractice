package com.dsal.leetcode.blind75.arrays;

public class MaxProductinContnsSubArray2 {

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
        int maxSoFar = arr[0];
        int currMinProd = arr[0];
        int currMaxProd = arr[0];

        for (int i = 1; i < n; i++) {

            int num = arr[i];

            if(num < 0){ // swap min and max product
                int temp = currMaxProd;
                currMaxProd = currMinProd;
                currMinProd = temp;
            }

            currMaxProd = Math.max(num, currMaxProd * num);
            currMinProd = Math.min(num, currMinProd * num);

            maxSoFar = Math.max(currMaxProd, maxSoFar);

        }
        return maxSoFar;
    }

}

/**
 Steps :

 Create 3 variable :-
 1. currMinProduct
 2. currMaxProduct
 3. result or maxSoFar

 Assign all above with arr[0], 0th element

 in the For Loop

 take ith element check if its negative

 if yes, then swap currMinProduct and currMaxProduct
    (We swap because multiplying by a negative number flips signs.
         Before multiplying by a negative number:
             largest positive  × negative = large negative
             largest negative × negative = large positive

         So:
             previous maxProd can become the new minimum
             previous minProd can become the new maximum

     That’s why we swap them before updating.)

 , and continue with calculation of currMinProduct and currMaxProduct

 get Maximum of maxSoFar and currMaxProduct - when the loop ends this will be the answer.


 This max is our answer
 */

