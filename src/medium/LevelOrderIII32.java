package medium;

import struct.TreeNode;

import java.util.*;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @since 2021-11-15 14:12
 */
public class LevelOrderIII32 {
  /**
   * 在LevelOrderII32(从上到下打印二叉树 II)的基础上添加一个对res的判断，判断是奇数层还是偶数 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.98% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 66.50% 的用户
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root != null) queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        tmp.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      if ((res.size() + 1) % 2 == 0) {
        Collections.reverse(tmp);
      }
      res.add(tmp);
    }
    return res;
  }
}
