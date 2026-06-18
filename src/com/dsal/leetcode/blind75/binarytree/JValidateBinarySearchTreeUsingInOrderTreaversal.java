package com.dsal.leetcode.blind75.binarytree;

import java.util.ArrayList;
import java.util.List;

public class JValidateBinarySearchTreeUsingInOrderTreaversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        boolean result = isValidBSTUsingListInOrder(root);
        System.out.println(result);

    }

    private static boolean isValidBSTUsingListInOrder(TreeNode root) {

        List<Integer> inOrderList = new ArrayList<>();

        getInOrderTraversalList(root, inOrderList);

        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= inOrderList.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private static void getInOrderTraversalList(TreeNode root, List<Integer> inOrderList) {

        if (root == null){
            return;
        }
        getInOrderTraversalList(root.left, inOrderList);
        inOrderList.add(root.val);
        getInOrderTraversalList(root.right, inOrderList);

    }
}
