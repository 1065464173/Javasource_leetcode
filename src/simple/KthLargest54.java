package simple;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @since 2021-11-24 16:11
 */
public class KthLargest54 {
  Deque<Integer> deque = new LinkedList<>();

  /**
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 8.14% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 5.07% 的用户
   *
   * @param root
   * @param k
   * @return
   */
  public int kthLargest1(TreeNode root, int k) {
    dfs1(root);
    while (deque.size() > k) {
      deque.pop();
    }
    return deque.pop();
  }

  private void dfs1(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs1(node.left);
    deque.offer(node.val);
    dfs1(node.right);
  }

  /**
   * 精选答案 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 64.32% 的用户
   */
  int res, k;

  public int kthLargest(TreeNode root, int k) {
    this.k = k;
    dfs(root);
    return res;
  }

  void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.right);
    if (k == 0) {
        return;
    }
    if (--k == 0) {
        res = root.val;
    }
    dfs(root.left);
  }
}
