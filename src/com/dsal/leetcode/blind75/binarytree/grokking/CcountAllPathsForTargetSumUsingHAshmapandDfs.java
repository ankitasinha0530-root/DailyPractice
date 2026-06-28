package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.HashMap;
import java.util.Map;

public class CcountAllPathsForTargetSumUsingHAshmapandDfs {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);

        root.right.left = new TreeNode(4);
        root.right.right= new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);


        int result = countAllPathsForASumFromAnyNode(root, 8);
        System.out.println("All Paths Count = " + result);
    }

    // with this method all TEst Case of LeetCode will pass
    private static int countAllPathsForASumFromAnyNode(TreeNode root, int targetSum) {

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        return countAllPathsForASumFromAnyNodeHelper(root, targetSum, prefixMap, 0);
    }

    private static int countAllPathsForASumFromAnyNodeHelper(TreeNode root, int targetSum,
                                                              Map<Integer, Integer> prefixMap, int currSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;

        int count = prefixMap.getOrDefault(currSum - targetSum, 0);

        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1); //put currSum in Map

        count += countAllPathsForASumFromAnyNodeHelper(root.left, targetSum, prefixMap, currSum);
        count += countAllPathsForASumFromAnyNodeHelper(root.right, targetSum, prefixMap, currSum);

        prefixMap.put(currSum, prefixMap.get(currSum) - 1); // backtrack
        return count;

    }

    private static int countAllPathsForASumFromAnyNodeHelperV2(TreeNode root, int targetSum,
                                                             Map<Integer, Integer> prefixMap, int currSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;

        int count = prefixMap.getOrDefault(currSum - targetSum, 0);

        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1); //put currSum in Map

        count += countAllPathsForASumFromAnyNodeHelper(root.left, targetSum, prefixMap, currSum);
        count += countAllPathsForASumFromAnyNodeHelper(root.right, targetSum, prefixMap, currSum);

        prefixMap.put(currSum, prefixMap.get(currSum) - 1); // backtrack
        return count;

    }

}
