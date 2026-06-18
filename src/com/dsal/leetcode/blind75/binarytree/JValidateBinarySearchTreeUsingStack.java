package com.dsal.leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class JValidateBinarySearchTreeUsingStack {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        boolean result = isValidBSTUsingStack(root);
        System.out.println(result);
    }

    private static boolean isValidBSTUsingStack(TreeNode root) {

        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(pre != null && root.val <= pre.val){
                return false;
            }

            pre = root;
            root = root.right;

        }

        return true;
    }

}
