package com.dsal.leetcode.blind75.binarytree;

public class IsBothTreeSame {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        TreeNode root2 = new TreeNode(10);

        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);

        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);

        root2.right.left = new TreeNode(12);
        root2.right.right = new TreeNode(20);

        System.out.println(isSameTree(root, root2));

        TreeNode root3 = new TreeNode(10);

        root3.left = new TreeNode(5);
        root3.right = new TreeNode(20);

        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(7);

        root3.right.left = new TreeNode(12);
        root3.right.right = new TreeNode(20);

        System.out.println(isSameTree(root, root3));
    }

    private static boolean isSameTree(TreeNode root, TreeNode root2) {

        if(root == null && root2 == null){
            return true;
        }

        if(root == null || root2 == null){
            return false;
        }

        if(root.val != root2.val) {
            return false;
        }

        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
    }

}
