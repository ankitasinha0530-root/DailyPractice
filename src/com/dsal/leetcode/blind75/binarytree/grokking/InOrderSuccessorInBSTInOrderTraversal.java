package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessorInBSTInOrderTraversal {

    // Find smallest among the roots next to the targetRoot

    // https://leetcode.com/problems/inorder-successor-in-bst/description/

    TreeNode prev = null;
    TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        //    return inorderSuccessorList(root, p);

        inorderSuccessorHelper(root, p);
        return res;

    }

    public void inorderSuccessorHelper(TreeNode root, TreeNode p) {

        if(root == null) {
            return;
        }

        inorderSuccessorHelper(root.left, p);

        if(prev != null && prev.val == p.val && res == null) {
            res = root;
            return;
        }
        prev = root;

        inorderSuccessorHelper(root.right, p);

    }

    public TreeNode inorderSuccessorList(TreeNode root, TreeNode p) {

        List<TreeNode> inOrderList = new ArrayList<>();

        inorderSuccessorListHelper(root, p, inOrderList);

        for(int i = 0; i < inOrderList.size(); i++){
            if(p.val == inOrderList.get(i).val){
                if( i < inOrderList.size() - 1){
                    return inOrderList.get(i + 1);
                }
            }
        }

        return null;

    }

    public void inorderSuccessorListHelper(TreeNode root, TreeNode p, List<TreeNode> inOrderList) {

        if(root == null) {
            return;
        }

        inorderSuccessorListHelper(root.left, p, inOrderList);

        inOrderList.add(root);

        inorderSuccessorListHelper(root.right, p, inOrderList);

    }
}
