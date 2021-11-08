package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @since 2021-11-08 09:52
 */
public class DiameterOfBinaryTree543 {
  int maxD = 0;

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 65.08% 的用户
   *
   * @param root
   * @return
   */
  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return maxD;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    maxD = Math.max(maxD, left + right);
    return Math.max(left, right) + 1;
  }
}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
