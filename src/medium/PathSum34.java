package medium;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给你二叉树的根节点root和一个整数目标和targetSum，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。 叶子节点是指没有子节点的节点。
 * @since 2021-11-24 13:51
 */
public class PathSum34 {

  List<List<Integer>> ret = new LinkedList<List<Integer>>();
  Deque<Integer> path = new LinkedList<Integer>();

  /**
   * dfs 深度优先搜索 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 23.35% 的用户
   *
   * @param root
   * @param target
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int target) {
    dfs(root, target);
    return ret;
  }

  public void dfs(TreeNode root, int target) {
    if (root == null) {
      return;
    }
    path.offerLast(root.val);
    target -= root.val;
    if (root.left == null && root.right == null && target == 0) {
      ret.add(new LinkedList<Integer>(path));
    }
    dfs(root.left, target);
    dfs(root.right, target);
    // 回溯
    path.pollLast();
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
