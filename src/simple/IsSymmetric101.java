package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉树，检查它是否是<b>镜像</b>对称的。 你可以运用递归和迭代两种方法解决这个问题吗
 * @author: Sxuet
 * @create: 2021-07-06 18:00
 */
public class IsSymmetric101 {
  /**
   * 自己写的递归 递归比较左树的左子树和右树的右子树是否相等，以及左树的右子树和右树的左子树是否相等。 当两个树都为空返回真，都不为空比较值是否相等，值相等比较子树的子树。。以此类推
   *
   * <p>时间复杂度O(n) 遍历了整棵树
   *
   * <p>空间复杂度O(n) 不超过树的层数
   *
   * <p>扩展了列表参数，新建方法isSymmetric(TreeNode left, TreeNode right)
   *
   * @param root
   * @return true/false
   */
  public boolean isSymmetric1(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left != null && right != null) {
      if (left.val == right.val) {
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
      }
    } else if (left == null && right == null) {
      return true;
    }
    return false;
  }

  /**
   * 使用迭代的方式完成
   *
   * <p>引入一个队列，这是把递归程序改写成迭代程序的常用方法
   *
   * <p>空间复杂符和时间复杂度同迭代的方法
   *
   * @param root
   * @return
   */
  public boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    q.offer(root);
    TreeNode node1;
    TreeNode node2;
    while (!q.isEmpty()) {
      node1 = q.poll();
      node2 = q.poll();
      if (node1 == null && node2 == null) {
        continue;
      }
      if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
        return false;
      }
      q.offer(node1.left);
      q.offer(node2.right);

      q.offer(node1.right);
      q.offer(node2.left);
    }
    return true;
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
