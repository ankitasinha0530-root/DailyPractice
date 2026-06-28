package com.dsal.leetcode.blind75.binarytree.grokking;

public class FPathWithAGivenSequenceRootToLeaf {

	public static void main(String[] args) {
		
		// refer video - https://www.youtube.com/watch?v=4u7KW3t-vt0

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(4);

		root.right.right= new TreeNode(5);

		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Sum of Path Numbers = " + pathWithGivenSequence(root, new int[] {2, 1, 5}));
		
		System.out.println(" Sum of Path Numbers = " + pathWithGivenSequence(root, new int[] {1, 4, 3}));

		System.out.println(" Sum of Path Numbers = " + pathWithGivenSequence(root, new int[] {2, 1, 4, 3}));

	}

	private static boolean pathWithGivenSequence(TreeNode root, int[] sequence) {

		return pathWithGivenSequence(root, sequence, 0);

	}

	private static boolean pathWithGivenSequence(TreeNode root, int[] sequence, int index) {

		if(root == null) {
			return false;
		}

		if(index >= sequence.length || root.val != sequence[index]){
			return false;
		}

		if (root.left == null && root.right == null && index == sequence.length - 1) {
			return true;
		}

		return pathWithGivenSequence(root.left, sequence, index + 1)
				|| pathWithGivenSequence(root.right, sequence, index + 1);
	}


}
