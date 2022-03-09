package simple;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 *     百度百科中最近公共祖先的定义为：“对于有根树T的两个结点、q，最近公共祖先表示为一个结点x，满足是、q的祖先且x的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *     例如，给定如下二叉树：root=【3，5，1，6，2，0，8，null，null，7，4】
 * @since 2021-11-28 16:13
 */
public class lowestCommonAncestorII68 {
  /**
   * 执行用时： 6 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 37.08% 的用户
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) {
      return root;
    }

    TreeNode l = lowestCommonAncestor(root.left, p, q);
    TreeNode r = lowestCommonAncestor(root.right, p, q);

    return l == null ? r : (r == null ? l : root);
  }
}
