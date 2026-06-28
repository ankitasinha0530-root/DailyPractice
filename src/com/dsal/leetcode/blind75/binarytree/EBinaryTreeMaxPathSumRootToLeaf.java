package com.dsal.leetcode.blind75.binarytree;

public class EBinaryTreeMaxPathSumRootToLeaf {

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

//        System.out.println(" Max height of a tree = " + binaryTreeMaxPathSumRootToLeaf(root, 0));
        binaryTreeMaxPathSumRootToLeaf(root, 0);
        System.out.println(maxSum);

        TreeNode root2 = new TreeNode(2);

        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);

        root2.left.left = new TreeNode(9);

        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        root2.right.left.left = new TreeNode(3);
        root2.right.left.right = new TreeNode(18);

        maxSum = 0;
        binaryTreeMaxPathSumRootToLeaf(root2, 0);
        System.out.println(maxSum);
    }

    private static void binaryTreeMaxPathSumRootToLeaf(TreeNode root, int sum) {

        if(root == null){
            maxSum = Math.max(maxSum, sum); // whenever we reach root compare sum and max sum
            return;
        }

        sum += root.val;

        binaryTreeMaxPathSumRootToLeaf(root.left, sum);
        binaryTreeMaxPathSumRootToLeaf(root.right, sum);

    }
}
