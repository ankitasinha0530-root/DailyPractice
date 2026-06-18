package com.dsal.leetcode.blind75.binarytree;

public class IConstructBinaryTreeFromPreorderAndInorderTraversal {
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
