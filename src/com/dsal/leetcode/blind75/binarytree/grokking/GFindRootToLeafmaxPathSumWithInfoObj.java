package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class GFindRootToLeafmaxPathSumWithInfoObj {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);

		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		PathInfo resultPathInfo = rootToLeafMaxSumPath(root);
		System.out.println("Sum : " + resultPathInfo.sum + ", Path = " + resultPathInfo.path);

	}

	static class PathInfo {
		int sum;
		List<Integer> path;

		PathInfo(int sum, List<Integer> path) {
			this.sum = sum;
			this.path = path;
		}
	}

	private static PathInfo rootToLeafMaxSumPath(TreeNode root) {

		if (root == null) {
			return new PathInfo(Integer.MIN_VALUE, new ArrayList<>());
		}

		if (root.left == null && root.right == null) {
			List<Integer> path = new ArrayList<>();
			path.add(root.val);

			return new PathInfo(root.val, path);
		}

		PathInfo left = rootToLeafMaxSumPath(root.left); //left call
		PathInfo right = rootToLeafMaxSumPath(root.right); // right call

		PathInfo better = left.sum > right.sum ? left : right;

		List<Integer> path = new ArrayList<>();
		path.add(root.val);
		path.addAll(better.path);

		return new PathInfo(
				root.val + better.sum,
				path
		);
	}
}
