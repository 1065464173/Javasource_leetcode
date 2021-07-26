package simple;

import struct.TreeNode;

/**
 * @program: Javasource_leetcode
 * @description: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *     <p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author: Sxuet
 * @create: 2021-07-05 13:19
 */
public class IsSameTree100 {
  /**
   * 自己写的深度优先递归 递归判断子树是否是同样的树 时间复杂度O(min(m,n)) 空间复杂度:O(min(m,n) 取决于递归层数
   *
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      if (p.val == q.val) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      }
    }
    return q == null && p == null;
  }
}
