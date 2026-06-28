package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class BAllPathsForTargetSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);

        root.right.left = new TreeNode(4);
        root.right.right= new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);


        List<List<Integer>> result = allPathsForASumFromAnyNode(root, 8);
        System.out.println("All Paths = " + result);
    }

    private static List<List<Integer>> allPathsForASumFromAnyNode(TreeNode root, int targetSum) {

        List<List<Integer>> resultAllPaths = new ArrayList<>();

        allPathsForASumFromAnyNodeHelper(root, targetSum, new ArrayList<>(), resultAllPaths);

        return resultAllPaths;
    }

    private static void allPathsForASumFromAnyNodeHelper(TreeNode root, int targetSum, ArrayList<Integer> currPath, List<List<Integer>> resultAllPaths) {

        if (root == null) {
            return;
        }

        currPath.add(root.val);

        allPathsForASumFromAnyNodeHelper(root.left, targetSum, currPath, resultAllPaths);
        allPathsForASumFromAnyNodeHelper(root.right, targetSum, currPath, resultAllPaths);

        int sum = 0;
        for (int i = currPath.size() - 1; i >= 0; i--) {

            sum += currPath.get(i);

            if(targetSum == sum){
                List<Integer> tempList = new ArrayList<>();
                for (int j = i; j < currPath.size(); j++) {
                    tempList.add(currPath.get(j));
                }
                resultAllPaths.add(tempList);
            }
        }
        currPath.removeLast(); // currPath.remove(currPath.size()-1);
    }
}
