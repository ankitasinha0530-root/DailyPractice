package com.dsal.leetcode.blind75.binarytree;

public class HSubTreeOfAnotherTreeUsingPreOrderValCheck {

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

        System.out.println(subTreeOfAnotherTreeValCheck(root, subRoot));
    }

    private static boolean subTreeOfAnotherTreeValCheck(TreeNode root, TreeNode subRoot) {

        if( root == null && subRoot == null){
            return true;
        }
        if( root == null || subRoot == null){
            return false;
        }

        if(root.val == subRoot.val){
            if(isDuplicate(root, subRoot)){
                return true;
            }
        }

        return subTreeOfAnotherTreeValCheck(root.left, subRoot) || subTreeOfAnotherTreeValCheck(root.right, subRoot);
    }

    private static boolean isDuplicate(TreeNode root, TreeNode subRoot) {

        if( root == null && subRoot == null){
            return true;
        }
        if( root == null || subRoot == null){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        return isDuplicate(root.left, subRoot.left) && isDuplicate(root.right, subRoot.right);
    }

}
