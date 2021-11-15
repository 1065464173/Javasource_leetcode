package simple;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @since 2021-11-15 13:18
 */
public class LevelOrder32 {
  /**
   * 使用队列存储<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.54% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 65.36% 的用户
   *
   * @param root
   * @return
   */
  public int[] levelOrder(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> ansQueue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      ansQueue.offer(node);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    int index = 0;
    int[] ans = new int[ansQueue.size()];
    while (!ansQueue.isEmpty()) {
      ans[index++] = ansQueue.poll().val;
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
 *     TreeNode(int x) { val = x; }
 * }
 */
