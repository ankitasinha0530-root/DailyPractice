package com.dsal.leetcode.blind75.binarytree;

public class MaxHeightOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(12);

        System.out.println(" Max height of a tree = " + maxHeightofABinaryTree(root));
    }

    private static int maxHeightofABinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftHeight = maxHeightofABinaryTree(root.left);
        int rightHeight = maxHeightofABinaryTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
