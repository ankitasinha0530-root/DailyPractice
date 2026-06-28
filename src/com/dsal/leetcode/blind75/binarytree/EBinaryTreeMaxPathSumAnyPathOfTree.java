package com.dsal.leetcode.blind75.binarytree;

public class EBinaryTreeMaxPathSumAnyPathOfTree {

    static int maxSumPath = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        maxSumAnyPath(root);
        System.out.println(maxSumPath);

        TreeNode root2 = new TreeNode(2);

        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);

        root2.left.left = new TreeNode(9);

        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        root2.right.left.left = new TreeNode(3);
        root2.right.left.right = new TreeNode(18);

        maxSumPath = 0;
        maxSumAnyPath(root2);
        System.out.println(maxSumPath);
    }

    private static int maxSumAnyPath(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftSum = maxSumAnyPath(root.left);
        int rightSum = maxSumAnyPath(root.right);

        maxSumPath = Math.max(maxSumPath, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}
