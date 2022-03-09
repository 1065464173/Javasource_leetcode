package simple;

import struct.TreeNode;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *     <p>高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author: Sxuet
 * @create: 2021-07-08 14:27
 */
public class SortedArrayToBST108 {
  /**
   * 时间复杂度O(n) 数组的长度
   *
   * <p>空间复杂度O(logn) 递归栈的深度
   *
   * @param nums
   * @return
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return null;
    }
    // 理论上可能造成整型溢出 overflow
    // 中序遍历：总是选择中间位置左边的数字作为根节点向下取整数
    //    int mid = (endIndex + startIndex) / 2;
    //    int mid = startIndex +(endIndex - startIndex)/2;

    // 中序遍历：总是选择中间位置右边的数字作为根节点
    //    int mid = (endIndex + startIndex+1) / 2;
    // 中序遍历，选择任意一个中间位置数字作为根节点
    int mid = (startIndex + endIndex + (int) (Math.random() * 2)) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedArrayToBST(nums, startIndex, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, endIndex);
    return node;
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
