package com.dsal.leetcode.blind75.binarytree;

public class HSubTreeOfAnotherTreeUsingPreOrderString {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);

        root.right.left.left = new TreeNode(11);
        root.right.right.right = new TreeNode(25);

        TreeNode subRoot = new TreeNode(15);

        subRoot.left = new TreeNode(12);
        subRoot.right = new TreeNode(20);

        subRoot.left.left = new TreeNode(11);
        subRoot.right.right = new TreeNode(25);

        System.out.println(subTreeOfAnotherTree(root, subRoot));
    }

    private static boolean subTreeOfAnotherTree(TreeNode root, TreeNode subRoot) {

        StringBuilder sbRoot = new StringBuilder();

        StringBuilder sbSubRoot = new StringBuilder();

        rootTreeString(root,sbRoot);

        rootTreeString(subRoot,sbSubRoot);

        return sbRoot.toString().contains(sbSubRoot.toString());

    }

    private static void rootTreeString(TreeNode root, StringBuilder sbRoot) {

        if(root == null){
            return;
        }
        sbRoot.append(root.val);

        rootTreeString(root.left, sbRoot);
        rootTreeString(root.right, sbRoot);
    }

}
