package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @since 2021-11-16 15:49
 */
public class MirrorTree27 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 24.89% 的用户
   *
   * @param root
   * @return
   */
  public TreeNode mirrorTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode temp = mirrorTree(root.left);
    root.left = mirrorTree(root.right);
    root.right = temp;
    return root;
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
