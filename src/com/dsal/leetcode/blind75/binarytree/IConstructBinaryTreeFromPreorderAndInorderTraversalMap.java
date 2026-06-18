package com.dsal.leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class IConstructBinaryTreeFromPreorderAndInorderTraversalMap {

    private static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        printPreOrder(root);

    }

    private static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return buildTreeHelper(preOrder, inOrderMap, 0, 0, inOrder.length);

    }

    private static TreeNode buildTreeHelper(int[] preOrder, Map<Integer, Integer> inOrderMap,
                                            int preOrderRootIdx, int inOrderStartIdx, int inOrderEndIdx) {

        if (preOrderRootIdx >= preOrder.length || inOrderStartIdx > inOrderEndIdx) {
            return null;
        }
        int rootVal = preOrder[preOrderRootIdx];
        int rootIdxInInOrder = inOrderMap.get(rootVal);
        int sizeOfLeftOfRoot = rootIdxInInOrder - inOrderStartIdx;

        TreeNode root = new TreeNode(rootVal);

        if(rootIdxInInOrder > inOrderStartIdx){
            root.left = buildTreeHelper(preOrder, inOrderMap,
                    preOrderRootIdx + 1, inOrderStartIdx, rootIdxInInOrder - 1);
        }
        if(rootIdxInInOrder < inOrderEndIdx){
            root.right = buildTreeHelper(preOrder, inOrderMap,
                    preOrderRootIdx + sizeOfLeftOfRoot + 1,
                    rootIdxInInOrder + 1, inOrderEndIdx);
        }
        return root;
    }

    private static TreeNode buildTreeHelperV2(int[] preOrder, Map<Integer, Integer> inOrderMap,
                                        int preOrderRootIdx, int inOrderStartIdx, int inOrderEndIdx) {

        if (preOrderRootIdx >= preOrder.length || inOrderStartIdx > inOrderEndIdx) {
            return null;
        }
        int rootVal = preOrder[preOrderRootIdx];
        int rootIdxInInOrder = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        if(rootIdxInInOrder > inOrderStartIdx){
            root.left = buildTreeHelper(preOrder, inOrderMap,
                    preOrderRootIdx + 1, inOrderStartIdx, rootIdxInInOrder - 1);
        }
        if(rootIdxInInOrder < inOrderEndIdx){
            root.right = buildTreeHelper(preOrder, inOrderMap,
                    preOrderRootIdx + (rootIdxInInOrder - inOrderStartIdx) + 1,
                    rootIdxInInOrder + 1, inOrderEndIdx);
        }
        return root;
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) {
//            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");

        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}




/**
🧠 Intuition
To build the binary tree:

Preorder gives the root first, so we process elements from preorder in order.
Inorder helps us split the tree into left and right subtrees based on the root's position.
So, the first element from preorder is the root. Find its index in inorder to know where left and right subtrees start and end. Recur for both parts.

        🧩 Approach
Store inorder values and their indices in a map for O(1) lookup.

Maintain a global index to track the current root in preorder.

        Use recursion (helper) with start and end to define the current subtree range.

At each step:

Pick the root from preorder[index].
Find its position in inorder to divide into left and right.
Recurse on left and right subtrees.
*/
