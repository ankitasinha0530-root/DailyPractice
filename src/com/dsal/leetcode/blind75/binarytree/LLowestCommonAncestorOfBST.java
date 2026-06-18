package com.dsal.leetcode.blind75.binarytree;

public class LLowestCommonAncestorOfBST {

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

        System.out.println(lowestCommonAncestor(root, new TreeNode(12), new TreeNode(20)));

        System.out.println(lowestCommonAncestor(root, new TreeNode(1), new TreeNode(4)));

    }

    private static int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode currNode = root;

        while(currNode != null) {
            if (p.val <= currNode.val && q.val <= currNode.val) {
                currNode = currNode.left;
            } else if (p.val >= currNode.val && q.val >= currNode.val) {
                currNode = currNode.right;
            } else {
                return currNode.val;
            }
        }

        return -1;
    }
}

/**
Approach
The approach is to traverse the BST starting from the root. While traversing, compare the values of the current node (temp) with the values of p and q. Based on the comparison, update the temp node to either its left or right child until we find the lowest common ancestor.

Start with temp = root.
While temp is not None:
    If both p and q are greater than the value of temp, move to the right child (temp = temp.right).
    If both p and q are smaller than the value of temp, move to the left child (temp = temp.left).
    If the values of p and q are on opposite sides of temp (one is greater, and the other is smaller),
    temp is the lowest common ancestor. Return temp.*/
