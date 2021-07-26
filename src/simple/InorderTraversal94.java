package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 二叉树的中序遍历 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author: Sxuet
 * @create: 2021-07-05 12:19
 */
public class InorderTraversal94 {

  /**
   * 掌握 递归，求root 的中序遍历结果就是求左子树的遍历结果+根+右子树的遍历结果
   *
   * <p>时间复杂度:O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
   *
   * <p>空间复杂度:O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    inorder(root, res);
    return res;
  }

  public void inorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }

  /**
   * 掌握 使用栈迭代，与递归方式等价
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

  /**
   * 了解 Morris 遍历算法：找到前驱和后继
   *
   * <p>时间复杂度O(2n)=O(n)
   *
   * <p>空间复杂度O(1)
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    TreeNode predecessor = null;

    while (root != null) {
      if (root.left != null) {
        // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
        predecessor = root.left;
        while (predecessor.right != null && predecessor.right != root) {
          predecessor = predecessor.right;
        }

        // 让 predecessor 的右指针指向 root，继续遍历左子树
        if (predecessor.right == null) {
          predecessor.right = root;
          root = root.left;
        }
        // 说明左子树已经访问完了，我们需要断开链接
        else {
          res.add(root.val);
          predecessor.right = null;
          root = root.right;
        }
      }
      // 如果没有左孩子，则直接访问右孩子
      else {
        res.add(root.val);
        root = root.right;
      }
    }
    return res;
  }
}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left,TreeNode right)
 * { this.val = val; this.left = left; this.right = right; } }
 */
