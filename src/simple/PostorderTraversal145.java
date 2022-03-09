package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二叉树，返回它的 后序 遍历。
 *     <p>左右根
 * @author: Sxuet
 * @create: 2021-07-18 15:44
 */
public class PostorderTraversal145 {
  /**
   * 递归 时间空间 O(n)
   *
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal1(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    if (root.right != null) {
      list.addAll(postorderTraversal1(root.right));
    }
    if (root.left != null) {
      list.addAll(postorderTraversal1(root.left));
    }

    list.add(root.val);
    return list;
  }

  /**
   * 迭代 时间空间 O(n) 左右根 根右左
   *
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode node = null;
    while (!stack.isEmpty()) {
      node = stack.pop();
      list.add(node.val);
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    Collections.reverse(list);
    return list;
  }

  /**
   * Morris遍历 将空间复杂度将为1 连接每个右子树的最左子节点和当前根节点
   *
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal3(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    TreeNode cur = root, p = null;
    while (cur != null) {
      p = cur.right;
      // 寻找左子树最左边节点
      if (p != null) {
        while (p.left != null && p.left != cur) {
          p = p.left;
        }
        if (p.left == null) {
          // 连接
          list.add(cur.val);
          p.left = cur;
          cur = cur.right;
          continue;
        } else {
          // 断开连接
          p.left = null;
        }
      } else {
        list.add(cur.val);
      }
      // 寻找左子树
      cur = cur.left;
    }
    Collections.reverse(list);
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
