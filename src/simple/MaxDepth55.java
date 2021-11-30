package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @since 2021-11-27 13:24
 */
public class MaxDepth55 {
  /**
   * dfs <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 7.70% 的用户
   *
   * @param root
   * @return
   */
  public int maxDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = 1, right = 1;
    left += maxDepth1(root.left);
    right += maxDepth1(root.right);
    return Math.max(left, right);
  }

  /**
   * 官方简介到惊到我 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 7.28% 的用户
   *
   * @param root
   * @return
   */
  public int maxDepth2(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
  }
}
