package com.dsal.leetcode.blind75.binarytree;

public class KthSmallestElementInABST {
    static int count = 0;
    static int res = 0;
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

        kthSmallestElementInBST(root, 3);
        System.out.println(res);

        count = 0;

        kthSmallestElementInBST(root, 5);
        System.out.println(res);
    }

    private static void kthSmallestElementInBST(TreeNode root, int k) {

        if(root == null){
            return;
        }
        kthSmallestElementInBST(root.left, k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }

        kthSmallestElementInBST(root.right, k);
    }

}
