package com.dsal.leetcode.blind75.binarytree;

public class EBinaryTreeMaxPathSumAnyPath {

    static int maxSum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        System.out.println(maxSumAnyPath(root));
    }

    private static int maxSumAnyPath(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftSum = maxSumAnyPath(root.left);
        int rightSum = maxSumAnyPath(root.right);

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}
