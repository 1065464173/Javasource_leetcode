package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *     <p>注意：
 *     <p>给定的目标值 target 是一个浮点数 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * @author: Sxuet
 * @create: 2021-08-21 11:34
 */
public class ClosestValue270 {

  /**
   * 构建中序序列数组。 在数组中找到最接近的元素。 <br>
   * 时间 O(n) 空间O(n)
   *
   * @param root
   * @param target
   * @return
   */
  public int closestValue2(TreeNode root, double target) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    return Collections.min(
        nums, (o1, o2) -> Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1);
  }

  private void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) {
      return;
    }
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }

  /**
   * 迭代 一遍遍历树一边搜索最近的值<br>
   * 找到最近的值后立即停止遍历，目标值位于两个有序数组元素之间 <br>
   * 时间O(k) 最坏O(H+k) k为最接近元素的索引，H为树的高度
   *
   * @param root
   * @param target
   * @return
   */
  public int closestValue3(TreeNode root, double target) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    long pre = Long.MIN_VALUE;
    while (!stack.isEmpty() || root != null) {
      // 遍历左边的树 4 2 1
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (pre <= target && target < root.val) {
        return Math.abs(pre - target) < Math.abs(root.val - target) ? (int) pre : root.val;
      }
      pre = root.val;
      root = root.right;
    }
    return (int) pre;
  }

  /**
   * 二分搜索， 当目标值小于当前根，向左搜索，否则向右 <br>
   * 时间O(H) 空间O(1)
   *
   * @param root
   * @param target
   * @return
   */
  public int closestValue4(TreeNode root, double target) {
    int val, closest = root.val;
    while (root != null) {
      val = root.val;
      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
      root = target < root.val ? root.left : root.right;
    }
    return closest;
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
