package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @since 2021-11-27 13:48
 */
public class IsBalanced55 {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return Math.abs(height(root.left) - height(root.right)) <= 1
          && isBalanced(root.left)
          && isBalanced(root.right);
    }
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height(root.left), height(root.right)) + 1;
    }
  }
}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
