package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个二叉树，计算整个树的坡度。
 *     一个树的节点的坡度定义即为，该节点左子树的节点之和和右子树节点之和的差的绝对值。如果没有左子树的话，左子树的节点之和为0；没有右子树的话也是一样。空结点的坡度是0。
 *     整个树的坡度就是其所有节点的坡度之和。
 * @since 2021-11-09 09:44
 */
public class FindTilt563 {
  int tilt = 0;
  /** 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 88.82% 的用户 */
  public int findTilt(TreeNode root) {
    traverse(root);
    return tilt;
  }

  public int traverse(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = traverse(root.left);
    int right = traverse(root.right);
    tilt += Math.abs(left - right);
    return left + right + root.val;
  }
}
