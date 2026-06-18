package com.dsal.leetcode.blind75.binarytree;

public class DInvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        PrintHelper.printPreOrder(root);
        System.out.println();
        PrintHelper.printInOrder(root);

        TreeNode resultRoot = invertBinaryTree(root);

        System.out.println();
        System.out.println("Inverted");
        PrintHelper.printPreOrder(resultRoot);
        System.out.println();
        PrintHelper.printInOrder(resultRoot);

    }

    private static TreeNode invertBinaryTree(TreeNode root) {

        if(root == null){
            return null;
        }

        TreeNode left = invertBinaryTree(root.left);

        root.left= invertBinaryTree(root.right);
        root.right = left;

        return root;
    }
}
