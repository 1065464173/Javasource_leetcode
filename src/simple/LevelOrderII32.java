package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @since 2021-11-15 13:37
 */
public class LevelOrderII32 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 93.77% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 37.34% 的用户
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder1(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> ansQueue = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    while (!queue.isEmpty() || !ansQueue.isEmpty()) {
      List<Integer> temp = new LinkedList<>();
      ansQueue.offer(queue.poll());
      if (queue.isEmpty()) {
        while (!ansQueue.isEmpty()) {
          TreeNode poll = ansQueue.poll();
          temp.add(poll.val);
          if (poll.left != null) {
            queue.offer(poll.left);
          }
          if (poll.right != null) {
            queue.offer(poll.right);
          }
        }
      }
      if (temp.size() > 0) {
        ans.add(temp);
      }
    }
    return ans;
  }

  /**
   * 官方的答案 思路和我的差不多，但是更简洁明了<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 93.77% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 39.25% 的用户
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root != null) queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        tmp.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      res.add(tmp);
    }
    return res;
  }
}
