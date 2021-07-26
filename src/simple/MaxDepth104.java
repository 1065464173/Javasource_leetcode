package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉树，找出其最大深度。
 *     <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *     <p>说明: 叶子节点是指没有子节点的节点
 * @author: Sxuet
 * @create: 2021-07-07 11:39
 */
public class MaxDepth104 {
  /**
   * 自己写的递归 深度优先 DFS，Depth First Search
   *
   * <p>每个节点作为根节点的高就是加上Max(right,left)+1的高
   *
   * <p>，时间复杂度O(n)=遍历树上的每个节点。 空间复杂度O(hight)=树的层高
   *
   * @param root
   * @return
   */
  public int maxDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHight = maxDepth1(root.left);
    int rightHight = maxDepth1(root.right);
    return Math.max(leftHight, rightHight) + 1;
  }

  /**
   * 广度优先遍历 BFS，Breadth First Search
   *
   * <p>使用队列转换深度算法
   *
   * <p>每次下一层还有元素的时候层数+1
   *
   * @param root
   * @return
   */
  public int maxDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int ans = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size > 0) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
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
