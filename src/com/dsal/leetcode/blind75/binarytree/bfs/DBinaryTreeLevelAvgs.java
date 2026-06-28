package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.*;

public class DBinaryTreeLevelAvgs {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<Double> result = traverseLevelAvgs(root);
		System.out.println("Level Order Traversal = " + result);
		
		root.right.left.right.left = new TreeNode(21);

	}
	
	public static List<Double> traverseLevelAvgs(TreeNode root) {

		if(root == null){
			return new ArrayList<>();
		}


		List<Double> levelAvg = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			long sum = 0;

			for (int i = 0; i < levelSize; i++) {

				TreeNode currNode = queue.poll();

				if(currNode != null) {

					sum += currNode.val;

					if (currNode.left != null){
						queue.add(currNode.left);
					}
					if(currNode.right != null) {
						queue.add(currNode.right);
					}
				}
			}
			double avg = (double) sum/levelSize;
			levelAvg.add(avg);
		}
		return levelAvg;
	}


}
