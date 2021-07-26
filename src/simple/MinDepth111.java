package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉树，找出其最小深度。
 *     <p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *     <p>说明：叶子节点是指没有子节点的节点。
 * @author: Sxuet
 * @create: 2021-07-09 12:24
 */
public class MinDepth111 {
  /**
   * 深度优先搜索，遍历整棵树，记录最小的深度
   *
   * <p>时间复杂度 O(n) 树的节点
   *
   * <p>空间复杂度 O(H) 树的层高
   *
   * @param root
   * @return
   */
  public int minDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int minDep = Integer.MAX_VALUE;
    if (root.left != null) {
      minDep = Math.min(minDepth1(root.left), minDep);
    }
    if (root.right != null) {
      minDep = Math.min(minDepth1(root.right), minDep);
    }
    return minDep + 1;
  }

  /**
   * 广度优先,当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
   *
   * <p>时间复杂度：O(N)，其中N 是树的节点数。对每个节点访问一次。
   *
   * <p>空间复杂度O(N)，其中N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数
   *
   * @param root
   * @return
   */
  public int minDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int minDep = 1;
    Queue<TreeNode> deque = new LinkedList<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = deque.poll();
        if (cur.right == null && cur.left == null) {
          return minDep;
        }
        if (cur.left != null) {
          deque.offer(cur.left);
        }
        if (cur.right != null) {
          deque.offer(cur.right);
        }
      }
      minDep++;
    }
    return minDep;
  }
}
