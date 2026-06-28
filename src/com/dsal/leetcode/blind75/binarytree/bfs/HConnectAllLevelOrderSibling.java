package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class HConnectAllLevelOrderSibling {
	
	static class TreeNode {
		int val = 0;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		
		public TreeNode(int val){
			this.val = val;
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);

		TreeNode current = root;
		HConnectAllLevelOrderSibling.connectAllLvlOrdrSib(root);
		System.out.println("Level Order Traversal using next pointer = ");
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	private static void connectAllLvlOrdrSib(TreeNode root) {
		if(root == null) return;

		Queue<TreeNode> mq = new LinkedList<>();
		mq.add(root);
		TreeNode prevNode = null;
		
		while(!mq.isEmpty()) {

			TreeNode currNode = mq.poll();

			if(prevNode != null) {
				prevNode.next = currNode;
			}
			prevNode = currNode;
			
			if(currNode.left != null) {
				mq.add(currNode.left);
			}
			if(currNode.right != null) {
				mq.add(currNode.right);
			}
		}
	}

}
