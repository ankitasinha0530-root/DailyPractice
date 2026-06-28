package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class FReturnAllRootToLeafPath {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<List<Integer>> result = returnAllPathsRootToLeaf(root);
		System.out.println("Level Order Traversal = " + result);

		System.out.println();
		System.out.println(returnAllPathsRootToLeafV2(root));

	}

	private static List<List<Integer>> returnAllPathsRootToLeaf(TreeNode root) {

		List<List<Integer>> allPaths = new ArrayList<>();
		returnAllPathsRootToLeafHelper(root, new ArrayList<>(), allPaths);
		return allPaths;
	}

	private static void returnAllPathsRootToLeafHelper(TreeNode root, ArrayList<Integer> currPath, List<List<Integer>> allPaths) {

		if (root == null) {
			return;
		}

		currPath.add(root.val);

		if(root.left == null && root.right == null){
			allPaths.add(new ArrayList<>(currPath));
		}

		returnAllPathsRootToLeafHelper(root.left, currPath, allPaths);
		returnAllPathsRootToLeafHelper(root.right, currPath, allPaths);

		currPath.removeLast();
	}

	private static List<List<Integer>> returnAllPathsRootToLeafV2(TreeNode root) {

		List<List<Integer>> allPaths = new ArrayList<>();
		returnAllPathsRootToLeafHelperV2(root, new ArrayList<>(), allPaths);
		return allPaths;
	}

	private static void returnAllPathsRootToLeafHelperV2(TreeNode root, ArrayList<Integer> currPath, List<List<Integer>> allPaths) {

		if (root == null) {
			return;
		}

		currPath.add(root.val);

		if(root.left == null && root.right == null){
			allPaths.add(new ArrayList<>(currPath));
		}else {
			returnAllPathsRootToLeafHelperV2(root.left, currPath, allPaths);
			returnAllPathsRootToLeafHelperV2(root.right, currPath, allPaths);
		}
		currPath.removeLast();
	}

}
