package com.dsal.leetcode.blind75.binarytree;

import java.util.*;

public class AllNodesAtKdistanceFromTargetNodeLevelOrder {
    // https://www.youtube.com/watch?v=i9ORlEy6EsI
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;
        int k = 2;

        System.out.println(allNodesAtKdistanceFromTargetNode(root, target, k));

    }

    private static Object allNodesAtKdistanceFromTargetNode(TreeNode root, TreeNode target, int k) {

        return null;
    }

}
