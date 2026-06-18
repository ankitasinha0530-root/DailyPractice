package com.dsal.leetcode.blind75.binarytree;

public class PrintHelper {

    public static void printPreOrder(TreeNode root) {
        if (root == null) {
//            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");

        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
//            System.out.print("null ");
            return;
        }

        printPreOrder(root.left);
        System.out.print(root.val + " ");
        printPreOrder(root.right);
    }
}
