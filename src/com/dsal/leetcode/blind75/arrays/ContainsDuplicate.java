package com.dsal.leetcode.blind75.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1}; // if sorted
        System.out.println(containsDuplicate(nums)); // true
        System.out.println(containsDuplicate1(nums)); // true
        System.out.println(containsDuplicate2(nums)); // true
        System.out.println(containsDuplicate3(nums)); // true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2)); // false
        System.out.println(containsDuplicate1(nums2)); // false
        System.out.println(containsDuplicate2(nums2)); // false
        System.out.println(containsDuplicate3(nums2)); // false
    }

    // Solution 1
    // Using HashSet, and then check if the element already exists in HashSet
    private static boolean containsDuplicate(int[] nums) {

      Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Solution 2
    //  Sorting the Unsorted Array and then comparing each element with the previous elelement if they are the same
    private static boolean containsDuplicate1(int[] nums) {

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    // Solution 3
/**
    Arrays.stream(nums) → converts array to stream
    distinct() → removes duplicates
    count() → counts unique elements
    If unique count != original length → duplicates exist
 */
    private static boolean containsDuplicate2(int[] nums) {

       return Arrays.stream(nums)  // Convert Array to streams
               .distinct()      //remove duplicate elements
               .count() != nums.length;  // count() → counts unique elements, If unique count != original length → duplicates exist
    }

    // Solution 4
/**
     boxed() converts a primitive stream into wrapper objects.
     Arrays.stream(nums) = returns IntStream(primitive int)
     Collectors.toSet() works with objects like Integer, not primitive int.
     Hence, we use boxed function to convert int to Integer
 */
    private static boolean containsDuplicate3(int[] nums) {

        Set<Integer> set =  Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return set.size() != nums.length;
    }


}
