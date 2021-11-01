package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你一个二叉搜索树的根节点root，返回树中任意两不同节点值之间的最小差值。 差值是一个正数，其数值等于两值之差的绝对值。
 * @since 2021-11-01 10:47
 */
public class GetMinimumDifference530 {
  int pre;
  int ans;

  /**
   * morris 实现中序遍历 过程中比较遍历前后的差值记录最小值 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 45.84% 的用户 内存消耗： 38 MB , 在所有 Java 提交中击败了 74.07% 的用户
   *
   * @param root
   * @return
   */
  public int getMinimumDifference1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode cur1 = root;
    TreeNode cur2 = null;
    int ans = Integer.MAX_VALUE;
    int preVal = -1;

    while (cur1 != null) {
      cur2 = cur1.left;
      if (cur2 != null) {
        while (cur2.right != null && cur2.right != cur1) {
          cur2 = cur2.right;
        }
        if (cur2.right == null) {
          cur2.right = cur1;
          cur1 = cur1.left;
          continue;
        } else {
          cur2.right = null;
        }
      }
      if (preVal != -1) {
        ans = Math.min(ans, cur1.val - preVal);
      }
      preVal = (cur1.val);
      cur1 = cur1.right;
    }
    return ans;
  }

  /**
   * 官方的普通中序遍历，更快
   *
   * @param root
   * @return
   */
  public int getMinimumDifference2(TreeNode root) {
    ans = Integer.MAX_VALUE;
    pre = -1;
    dfs(root);
    return ans;
  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (pre == -1) {
      pre = root.val;
    } else {
      ans = Math.min(ans, root.val - pre);
      pre = root.val;
    }
    dfs(root.right);
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
