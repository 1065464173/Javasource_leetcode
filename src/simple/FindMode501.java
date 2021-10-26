package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个有相同值的二叉搜索树（BST），找出BST中的所有众数（出现频率最高的元素）。 假定BST有如下定义：
 *     。结点左子树中所含结点的值小于等于当前结点的值。结点右子树中所含结点的值大于等于当前结点的值，左子树和右子树都是二叉搜索树 例如：
 *     给定BST【1，null，2，2】，返回【2】.如果众数超过1个，不需考虑输出顺序
 * @since 2021-10-26 11:26
 */
public class FindMode501 {
  /**
   * Morris 遍历的实质就是避免用栈结构,具体是通过让底层节点指向 null 的空闲指针指回上层的某个节点，从而完成下层到上层的移动。
   *
   * <p>Morris 遍历的大体流程： <br>
   * 我们记当前节点的指针为 cur，如果 cur 所指向的节点没有左孩子，那么 cur 指针向右移动，即 cur = cur.right。 <br>
   * 如果 cur 所指向的节点有左孩子，那么先找到 cur 左子树的最右的节点，并使用 mostright 指针指向该最右节点。 1）如果 mostright 所指向的节点的 right
   * 指针为空，那么让mostright 的 right 指针指向 cur，然后cur 指针向左移动； 2）如果 mostright 所指向的节点的 right 指向 cur，那么让 right
   * 重新指向空，然后 cur 向右移动。
   *
   * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 40.79% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 33.77% 的用户
   */
  int base, count, maxCount;

  List<Integer> answer = new ArrayList<Integer>();

  public int[] findMode(TreeNode root) {
    // 初始化
    TreeNode cur = root, pre = null;
    // 当前节点不为空时，找到其左子树的最右节点，使其右节指向当前节点
    while (cur != null) {
      if (cur.left == null) {
        update(cur.val);
        cur = cur.right;
        continue;
      }
      // 找到其左子树的最右节点，使其右节指向当前节点
      pre = cur.left;
      while (pre.right != null && pre.right != cur) {
        pre = pre.right;
      }
      if (pre.right == null) {
        pre.right = cur;
        cur = cur.left;
      } else {
        pre.right = null;
        update(cur.val);
        cur = cur.right;
      }
    }
    int[] mode = new int[answer.size()];
    for (int i = 0; i < answer.size(); ++i) {
      mode[i] = answer.get(i);
    }
    return mode;
  }

  public void update(int x) {
    if (x == base) {
      ++count;
    } else {
      count = 1;
      base = x;
    }
    if (count == maxCount) {
      answer.add(base);
    }
    if (count > maxCount) {
      maxCount = count;
      answer.clear();
      answer.add(base);
    }
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
