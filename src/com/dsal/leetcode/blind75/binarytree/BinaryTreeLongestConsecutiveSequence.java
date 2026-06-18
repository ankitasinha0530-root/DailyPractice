package com.dsal.leetcode.blind75.binarytree;

public class BinaryTreeLongestConsecutiveSequence {

    static int maxCount = 0;
    public static void main(String[] args) {
        // https://www.youtube.com/watch?v=uIckKXYhZsY

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        longestConsecutiveSeqNodeCount(root);
        System.out.println(maxCount);

    }

    public static int longestConsecutiveSeqNodeCount(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftCount = longestConsecutiveSeqNodeCount(root.left);
        int rightCount = longestConsecutiveSeqNodeCount(root.right);

        if(root.left != null && root.val + 1 == root.left.val){
            leftCount += 1;
        }else{
            leftCount = 1;
        }
        if(root.right != null && root.val + 1 == root.right.val){
            rightCount += 1;
        }else{
            rightCount = 1;
        }

        maxCount = Math.max(maxCount, Math.max(leftCount, rightCount));

        return Math.max(leftCount, rightCount);
    }
}
