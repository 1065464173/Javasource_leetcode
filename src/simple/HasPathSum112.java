package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点
 *     的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *     <p>叶子节点 是指没有子节点的节点。
 * @author: Sxuet
 * @create: 2021-07-10 12:13
 */
public class HasPathSum112 {
  /**
   * BFS广度优先
   *
   * <p>时间复杂度O(n) 树节点
   *
   * <p>空间复杂度O(n) 队列的开销。不会超过树节点个数
   *
   * @param root
   * @param targetSum
   * @return
   */
  public boolean hasPathSum1(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> deque = new LinkedList<>();
    Queue<Integer> sum = new LinkedList<>();
    deque.offer(root);
    sum.offer(root.val);
    while (!deque.isEmpty() && !sum.isEmpty()) {
      TreeNode node = deque.poll();
      Integer currentSum = sum.poll();
      if (node.left == null && node.right == null && currentSum == targetSum) {
        return true;
      }
      if (node.left != null) {
        deque.offer(node.left);
        sum.offer(node.left.val + currentSum);
      }
      if (node.right != null) {
        deque.offer(node.right);
        sum.offer(node.right.val + currentSum);
      }
    }
    return false;
  }

  /**
   * 普通递归
   *
   * <p>时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
   *
   * <p>空间复杂度: O(H)，其中H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为
   * O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为O(logN)。
   *
   * @param root
   * @param targetSum
   * @return
   */
  public boolean hasPathSum2(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }
    return hasPathSum2(root.left, targetSum - root.val)
        || hasPathSum2(root.right, targetSum - root.val);
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
