package com.dsal.leetcode.blind75.binarytree.grokking;

public class MTreeDiameter {
	//Given a binary tree, find the length of its diameter. 
	//The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. 
	//The diameter of a tree may or may not pass through the root.
	
	// If the diameter passes through root then Diameter = leftHeight + RightHeight + 2
	
	// In order to find the diameter we need to find the height of left and right as well
	
	// refer video = https://www.youtube.com/watch?v=S0Bwgtn32uI
	// refer video = https://www.youtube.com/watch?v=zM9N_x_v_24
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Diameter of a tree = " + treeDiameter(root));
//		System.out.println(" Diameter of a tree V2 = " + treeDiameterV2(root));
		
	}
	static int diameter = 0;
	// Here we are extracting both maximum height and maximum diameter in the same call
	private static int treeDiameter(TreeNode root) {

		treeDiameterHelper(root, 0);

		return diameter;
	}

	private static int treeDiameterHelper(TreeNode root, int height) {

		if (root == null) {
			return 0;
		}

		int leftHeight = treeDiameterHelper(root.left, height);
		int rightHeight = treeDiameterHelper(root.right, height);

		diameter = Math.max(diameter, leftHeight + rightHeight);

		return Math.max(leftHeight, rightHeight) + 1;

	}

}