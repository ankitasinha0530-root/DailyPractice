package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CcountAllPathsForTargetSumUsingpostOrderLoop {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);

        root.right.left = new TreeNode(4);
        root.right.right= new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);


        int result = countAllPathsForASumAnyPath(root, 8);
        System.out.println("All Paths Count = " + result);
    }

    static int countPath = 0;

    // with this method one Test Case for LeetCode will fail
    private static int countAllPathsForASumAnyPath(TreeNode root, int targetSum) {

        countAllPathsForASumAnyPathHelper(root, targetSum, new ArrayList<>());

        return countPath;
    }

    private static void countAllPathsForASumAnyPathHelper(TreeNode root, int targetSum,
                                                             List<Integer> currPath) {
        if (root == null) {
            return ;
        }

        currPath.add(root.val);

        countAllPathsForASumAnyPathHelper(root.left, targetSum, currPath);
        countAllPathsForASumAnyPathHelper(root.right, targetSum, currPath);

        int sum = 0;

        for (int i = currPath.size() - 1; i >= 0 ; i--) {

            sum += currPath.get(i);
            if(targetSum == sum){
                countPath++;
            }
        }
        currPath.removeLast();

    }

}
