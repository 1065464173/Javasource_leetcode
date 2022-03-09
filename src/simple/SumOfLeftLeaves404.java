package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 计算给定二叉树的所有左叶子之和。
 * @author: Sxuet
 * @create: 2021-09-12 20:24
 */
public class SumOfLeftLeaves404 {
  /**
   * 深度优先搜索<br>
   * 时间复杂度：O（n），空间复杂度：O（n）。<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 65.23% 的用户<br>
   * 如果它的左子节点是一个叶子结点，那么就将它的左子节点的值累加计入答案。
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves1(TreeNode root) {
    return root != null ? dfs(root) : 0;
  }

  public int dfs(TreeNode node) {
    int ans = 0;
    if (node.left != null) {
      // 是左节点且是叶子节点就添加值，否则继续遍历左节点直到到达叶子左节点
      ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
    }
    // 遍历右节点
    if (node.right != null && !isLeafNode(node.right)) {
      ans += dfs(node.right);
    }
    return ans;
  }

  /**
   * 广度优先搜索dns <br>
   * 时间复杂度：O（n），空间复杂度：O（n）。<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 63.51% 的用户
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        if (isLeafNode(node.left)) {
          ans += node.left.val;
        } else {
          queue.offer(node.left);
        }
      }
      if (node.right != null) {
        if (!isLeafNode(node.right)) {
          queue.offer(node.right);
        }
      }
    }
    return ans;
  }

  // 判断是否是叶子节点
  public boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }

  /**
   * 大佬评论区答案 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36 MB , 在所有 Java 提交中击败了 81.32% 的用户
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return sumOfLeftLeaves(root.left)
        + sumOfLeftLeaves(root.right)
        + (root.left != null && root.left.left == null && root.left.right == null
            ? root.left.val
            : 0);
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
