package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给你二叉树的根节点 root ，返回它节点值的 前序 遍历.(根左右)
 * @author: Sxuet
 * @create: 2021-07-17 22:56
 */
public class PreorderTraversal144 {
  /**
   * 自己写的递归 时间复杂度O(n) 空间复杂度O(n)
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.add(root.val);
    if (root.left != null) {
      list.addAll(preorderTraversal1(root.left));
    }
    if (root.right != null) {
      list.addAll(preorderTraversal1(root.right));
    }
    return list;
  }

  /**
   * 官方写的递归。空间使用率更低 只创建了一个list
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    preorder(root, list);
    return list;
  }

  private void preorder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    preorder(root.left, list);
    preorder(root.right, list);
  }

  /**
   * 迭代 区别于递归隐式地维护了一个栈
   *
   * <p>时间复杂度O(n) 空间复杂度 平均O(logn) 最坏O(n)
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal3(TreeNode root) {

    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return list;
  }

  /**
   * Morris 遍历
   *
   * <p>时间复杂度O(n) 空间复杂度O(1)
   *
   * <p>新建临时节点，令该节点为 root；
   *
   * <p>如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
   *
   * <p>如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
   *
   * <p>如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
   *
   * <p>如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
   *
   * <p>总而言之：每个节点找到它左子树最右边的节点相连即可
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal4(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    // p1 当前开始遍历的节点，p2当前节点的左子树
    TreeNode p1 = root, p2 = null;
    while (p1 != null) {
      p2 = p1.left;
      if (p2 != null) {
        while (p2.right != null && p2.right != p1) {
          // 找到当前左子树最右侧的节点，该节点指向根点之前
          p2 = p2.right;
        }
        if (p2.right == null) {
          // 如果这个最右侧节点的右指针没有指向根节点，创建连接然后往下一个左子树的根节点进行连接操作
          list.add(p1.val);
          p2.right = p1;
          p1 = p1.left;
          continue;
        } else {
          p2.right = null;
        }
      } else {
        // 当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，同时在回到根结点的时候我们应该已经处理完 左子树的最右侧节点 了，把路断开。
        list.add(p1.val);
      }
      // 一直往右走
      p1 = p1.right;
    }
    return list;
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
