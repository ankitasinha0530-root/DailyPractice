package com.dsal.leetcode.blind75.binarytree.grokking;

public class InOrderSuccessorInBST {

    // Find smallest among the roots next to the targetRoot

    // https://leetcode.com/problems/inorder-successor-in-bst/description/

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root == null)
                return null;

            if(p.right != null)
                return findSmallest(p.right);

            TreeNode succ = null;
            TreeNode cur = root;
            while(cur != p)
            {
                if(p.val < cur.val)
                {
                    succ = cur;
                    cur = cur.left;
                }
                else if(p.val > cur.val)
                    cur = cur.right;
            }
            return succ;

        }
        private TreeNode findSmallest(TreeNode root)
        {
            TreeNode cur = root;
            while(cur.left != null)
                cur = cur.left;
            return cur;
        }
    }
}
