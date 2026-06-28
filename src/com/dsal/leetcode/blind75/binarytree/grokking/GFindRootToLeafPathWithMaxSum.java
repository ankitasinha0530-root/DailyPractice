package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class GFindRootToLeafPathWithMaxSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);

		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<Integer> result = rootToLeafPathWithMaxSum(root);
		System.out.println("Root To leaf path mith maximum sum = " + result);

	}

	static int maxSum = 0;

	private static List<Integer> rootToLeafPathWithMaxSum(TreeNode root) {

		List<Integer> ansPath = new ArrayList<>();

		rootToLeafPathWithMaxSumHelper(root, 0, new ArrayList<>(), ansPath);
		return ansPath;

	}

	private static void rootToLeafPathWithMaxSumHelper(TreeNode root, int currSum, List<Integer> currPath, List<Integer> ansPath) {

		if (root == null) {
			return;
		}

		currPath.add(root.val);
		currSum += root.val;

		if(root.left == null && root.right == null) {

			if (currSum > maxSum) {
				maxSum = currSum;

				ansPath.clear();
				ansPath.addAll(new ArrayList<>(currPath));
			}
		}
		rootToLeafPathWithMaxSumHelper(root.left, currSum, currPath, ansPath);
		rootToLeafPathWithMaxSumHelper(root.right, currSum, currPath, ansPath);

		currPath.removeLast();
    }


}
