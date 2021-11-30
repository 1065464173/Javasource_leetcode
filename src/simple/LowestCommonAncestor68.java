package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先。
 *     百度百科中最近公共祖先的定义为：“对于有根树T的两个结点、q，最近公共祖先表示为一个结点x，满足x是、q的祖先且x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *     例如，给定如下二叉搜索树：root=【6，2，8，0，4，7，9，null，null，3，5】
 * @since 2021-11-28 15:22
 */
public class LowestCommonAncestor68 {
  /**
   * 两次遍历，先找到两个目标节点的路径，由于在最近共同祖先前面的路径都相等，所以最后遍历到这个节点就好了 <br>
   * 执行用时： 6 ms , 在所有 Java 提交中击败了 61.74% 的用户 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 27.03% 的用户
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> path_p = getPath(root, p);
    List<TreeNode> path_q = getPath(root, q);
    TreeNode ancestor = null;
    for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
      if (path_p.get(i) == path_q.get(i)) {
        ancestor = path_p.get(i);
      } else {
        break;
      }
    }
    return ancestor;
  }

  private List<TreeNode> getPath(TreeNode root, TreeNode target) {
    List<TreeNode> path = new ArrayList<>();
    TreeNode node = root;
    while (node != target) {
      path.add(node);
      if (target.val < node.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }
    path.add(node);
    return path;
  }

  /**
   * 执行用时： 5 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 5.05% 的用户 <br>
   * 由于这是搜索二叉树，所以我们可以根据节点的值判断
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (p.val < ancestor.val && q.val < ancestor.val) {
        ancestor = ancestor.left;
      } else if (p.val > ancestor.val && q.val > ancestor.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }
    return ancestor;
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
