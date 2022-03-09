package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *     <p>百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 *     的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *     <p>例如，给定如下二叉搜索树:root =[6,2,8,0,4,7,9,null,null,3,5]
 * @author: Sxuet
 * @create: 2021-08-09 21:36
 */
public class LowestCommonAncestor235 {
  /**
   * 两次遍历 时间复杂O(n) n为数的节点个数，最坏树呈链式 空间O(n) 需要储存根到p和q 的路径
   *
   * <p>我们从根节点开始遍历； 如果当前节点就是p，那么成功地找到了节点； 如果当前节点的值大于 p 的值，说明 p 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
   * 如果当前节点的值小于 p 的值，说明p 应该在当前节点的右子树，因此将当前节点移动到它的右子节点。
   *
   * <p>执行用时： 7 ms , 在所有 Java 提交中击败了 29.05% 的用户 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 67.18% 的用户
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    // 获取到达p、q的路径上的说有TreeNode集合
    List<TreeNode> path_p = getPath(root, p);
    List<TreeNode> path_q = getPath(root, q);
    // 初始化祖先ancestor
    TreeNode ancestor = null;
    // 遍历path_p和path_q,获取最后一个分叉路口的值。
    for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
      if (path_p.get(i) == path_q.get(i)) {
        ancestor = path_p.get(i);
      } else {
        break;
      }
    }
    return ancestor;
  }

  private List<TreeNode> getPath(TreeNode root, TreeNode target) {
    List<TreeNode> path = new ArrayList<TreeNode>();
    while (root != target) {
      path.add(root);
      int v1 = root.val;
      int v2 = target.val;
      if (v1 > v2) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    path.add(root);
    return path;
  }

  /**
   * 一次遍历 优化第一种方法，一次遍历两个路径 时间O(n) 空间O(1)
   *
   * <p>我们从根节点开始遍历； 如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点； 如果当前节点的值小于 p 和 q
   * 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点； 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时， p 和 q
   * 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
   *
   * <p>执行用时： 5 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 96.81% 的用户
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (ancestor.val > p.val && ancestor.val > q.val) {
        ancestor = ancestor.left;
      } else if (ancestor.val < p.val && ancestor.val < q.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }
    return ancestor;
  }

  /**
   * 递归
   *
   * <p>执行用时： 6 ms , 在所有 Java 提交中击败了 83.29% 的用户 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 85.65% 的用户
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

    if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor3(root.right, p, q);
    }
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor3(root.left, p, q);
    }
    return root;
  }
}

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
