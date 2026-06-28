package com.dsal.leetcode.blind75.binarytree.grokking;

public class ABinaryTreeHasPathForTargetFromRootToLeaf {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        System.out.println(binaryTreeHasPathForTargetFromRootToLeaf(root, 10, 0));
        System.out.println(binaryTreeHasPathForTargetFromRootToLeafV2(root, 10));
        System.out.println();

        TreeNode root2 = new TreeNode(2);

        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);

        root2.left.left = new TreeNode(9);

        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        root2.right.left.left = new TreeNode(3);
        root2.right.left.right = new TreeNode(18);

        System.out.println(binaryTreeHasPathForTargetFromRootToLeaf(root2, 100, 0));

        System.out.println(binaryTreeHasPathForTargetFromRootToLeafV2(root2, 100));
    }

    private static boolean binaryTreeHasPathForTargetFromRootToLeaf(TreeNode root, int target, int pathSum) {

        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && target == pathSum + root.val){
            return true;
        }

        pathSum += root.val;

        boolean isLeftHasPath = binaryTreeHasPathForTargetFromRootToLeaf(root.left, target, pathSum);
        boolean isRightHasPath = binaryTreeHasPathForTargetFromRootToLeaf(root.right, target, pathSum);

        return isLeftHasPath || isRightHasPath;
    }

    private static boolean binaryTreeHasPathForTargetFromRootToLeafV2(TreeNode root, int target) {

        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && target == root.val){
            return true;
        }

        boolean isLeftHasPath = binaryTreeHasPathForTargetFromRootToLeafV2(root.left, target - root.val);
        boolean isRightHasPath = binaryTreeHasPathForTargetFromRootToLeafV2(root.right, target - root.val);

        return isLeftHasPath || isRightHasPath;
    }
}
