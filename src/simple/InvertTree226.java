package simple;

import struct.TreeNode;

/**
 * @program: Javasource_leetcode
 * @description: 翻转一棵二叉树。
 * @author: Sxuet
 * @create: 2021-08-04 21:38
 */
public class InvertTree226 {
  /**
   * 时间复杂度O(n) 空间复杂度O(n)
   *
   * @param root
   * @return
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = left;
    return root;
  }
}
