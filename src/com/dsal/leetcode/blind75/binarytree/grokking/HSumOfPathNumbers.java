package com.dsal.leetcode.blind75.binarytree.grokking;

public class HSumOfPathNumbers {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);

        root.right.left = new TreeNode(4);
        root.right.right= new TreeNode(5);

        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(8);

        System.out.println(" Sum of Path Numbers = " + sumOfPathNumbers(root));

        System.out.println(" Sum of Path Numbers V2 = " + sumOfPathNumbersv2(root));

    }

    static int sum = 0;

    private static int sumOfPathNumbers(TreeNode root) {

        sumOfPathNumbers(root, 0);

        return sum;
    }

    private static void sumOfPathNumbers(TreeNode root, int pathSum) {

        if (root == null) {
            return;
        }

        pathSum = pathSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += pathSum;
        }

        sumOfPathNumbers(root.left, pathSum);
        sumOfPathNumbers(root.right, pathSum);
    }


    private static int sumOfPathNumbersv2(TreeNode root) {

        return sumOfPathNumbersV2(root, 0);
    }

    private static int sumOfPathNumbersV2(TreeNode root, int pathSum) {

        if (root == null) {
            return 0;
        }

        pathSum = pathSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return pathSum;
        }

        int leftPathSum = sumOfPathNumbersV2(root.left, pathSum);
        int rightPathSum = sumOfPathNumbersV2(root.right, pathSum);

        return leftPathSum + rightPathSum;
    }


}
