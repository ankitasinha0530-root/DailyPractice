package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class FReturnAllRootToLeafPath2 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<String> result = binaryTreePaths(root);
		System.out.println("Level Order Traversal = " + result);

		System.out.println();
		System.out.println(binaryTreePaths(root));

	}

	public static List<String> binaryTreePaths(TreeNode root) {

		List<String> allPaths = new ArrayList<>();

		binaryTreePaths(root, new ArrayList<>(), allPaths);

		return allPaths;

	}

	public static  void binaryTreePaths(TreeNode root, List<Integer> currPath, List<String> allPaths) {

		if (root == null){
			return;
		}

		currPath.add(root.val);

		if(root.left == null && root.right == null){

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < currPath.size(); i++){
				sb.append(currPath.get(i));
				if(i < currPath.size() - 1) {
					sb.append("->");
				}
			}
			allPaths.add(sb.toString());

		} else {
			binaryTreePaths(root.left, currPath, allPaths);
			binaryTreePaths(root.right, currPath, allPaths);
		}

		currPath.removeLast();

	}

}
