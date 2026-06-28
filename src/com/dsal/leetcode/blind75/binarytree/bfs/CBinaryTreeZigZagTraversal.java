package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBinaryTreeZigZagTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);

		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);

		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<List<Integer>> result = CBinaryTreeZigZagTraversal.traverseZigZag(root);
		System.out.println("Level Order Traversal = " + result);

	}

	private static List<List<Integer>> traverseZigZag(TreeNode root) {

		List<List<Integer>> zigZagList = new ArrayList<List<Integer>>();
		
		if(root == null) return zigZagList;
		
		Queue<TreeNode>  mq = new LinkedList<>(); //since we will storing nodes thus Queue will be of linkedlist.
		
		mq.add(root);

		boolean leftToRight = true;  // since we always start with clockwise which is L to R thus true.
		
		while(!mq.isEmpty()) {

			List<Integer> currLevel = new LinkedList<>();

			int levelSize = mq.size();
			
			for(int i = 0; i < levelSize; i++) {

				TreeNode currNode = mq.poll();

				if(currNode != null) {

					if (leftToRight) {
						currLevel.add(currNode.val);
					} else {
						currLevel.addFirst(currNode.val); // currLevel.add(0, currNode.val);
					}

					if (currNode.left != null) {
						mq.offer(currNode.left);
					}

					if (currNode.right != null) {
						mq.offer(currNode.right);
					}
				}
			}
			leftToRight = !leftToRight;
			zigZagList.add(currLevel);
		}

		return zigZagList;
	}



}
