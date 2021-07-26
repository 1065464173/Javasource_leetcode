package simple;

import struct.TreeNode;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *     <p>本题中，一棵高度平衡二叉树定义为：
 *     <p>一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @author: Sxuet
 * @create: 2021-07-08 15:02
 */
public class IsBalanced110 {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 自顶向下
    //    return Math.abs(height1(root.right) - height1(root.left)) <= 1
    //        && isBalanced(root.left)
    //        && isBalanced(root.right);
    // 自底向上
    return height2(root) != -1;
  }

  /**
   * 自顶向下递归(暴力解法)：判断每个节点 把顶部的值传递下去 对每个节点进行DFS
   *
   * <p>类似于前序遍历 首先计算左右子树的高度，如果左右子树的高度差是否不超过 1 ，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程。
   *
   * <p>时间复杂度O(n^2) n 是二叉树中节点的个数
   *
   * <p>空间复杂度 O(n) n 节点个数 空间复杂度取决于递归层数 递归层数不会超过n
   *
   * <p>函数 height height 会被重复调用，导致时间复杂度较高
   *
   * @param root
   * @return
   */
  private int height1(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height1(root.left), height1(root.right)) + 1;
    }
  }

  /**
   * 自底向上递归（提前阻断）： 进行一次DFS 把底部的值返回上来
   *
   * <p>类似于后序遍历 对于每个节点，函数 height height 只会被调用一次
   *
   * <p>如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡
   *
   * <p>时间复杂度O(n)
   *
   * <p>空间复杂度O(n)
   *
   * @param root
   * @return
   */
  private int height2(TreeNode root) {
    /*if (root == null) {
      return 0;
    }
    int leftHeight = height2(root.left);
    int rightHeight = height2(root.right);
    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }*/
    if (root == null) return 0;
    int left = height2(root.left);
    if (left == -1) return -1;
    int right = height2(root.right);
    if (right == -1) return -1;
    return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
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
