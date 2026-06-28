package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FBinaryTreeLevelOrderSuccessor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);

		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		TreeNode result = traverseLevelOrderSuccessor(root, 1);
		if(result != null) {
			System.out.println("Level Order Traversal = " + result.val);
		}
		TreeNode result1 = FBinaryTreeLevelOrderSuccessor.traverseLevelOrderSuccessor(root, 20);
		if(result1 != null) {
			System.out.println("Level Order Traversal = " + result1.val);
		}
		
		TreeNode result2 = FBinaryTreeLevelOrderSuccessor.traverseLevelOrderSuccessor(root, 17);
		if(result2 != null) {
			System.out.println("Level Order Traversal = " + result2.val);
		}
	}

	private static TreeNode traverseLevelOrderSuccessor(TreeNode root, int target) {

		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {

				TreeNode currNode = queue.poll();

				if(currNode.left != null){
					queue.add(currNode.left);
				}
				if(currNode.right != null){
					queue.add(currNode.right);
				}
				if (currNode.val == target) {
					return queue.peek();
				}
			}
		}

		return null;
	}

}
