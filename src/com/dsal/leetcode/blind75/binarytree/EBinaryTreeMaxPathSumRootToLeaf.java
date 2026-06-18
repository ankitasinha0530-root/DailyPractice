package com.dsal.leetcode.blind75.binarytree;

public class EBinaryTreeMaxPathSumRootToLeaf {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        System.out.println(" Max height of a tree = " + binaryTreeMaxPathSumRootToLeaf(root));
    }

    private static String binaryTreeMaxPathSumRootToLeaf(TreeNode root) {

        return null;
    }
}
