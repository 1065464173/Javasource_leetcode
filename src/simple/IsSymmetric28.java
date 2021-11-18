package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 例如，二叉树【1，2，2，3，4，4，3】是对称的。
 * @since 2021-11-16 16:09
 */
public class IsSymmetric28 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 96.21% 的用户
   *
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    return root == null ? true : recur(root.left, root.right);
  }

  boolean recur(TreeNode L, TreeNode R) {
    if (L == null && R == null) return true;
    if (L == null || R == null || L.val != R.val) return false;
    return recur(L.left, R.right) && recur(L.right, R.left);
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
