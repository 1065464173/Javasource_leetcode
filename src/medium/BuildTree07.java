package medium;

import struct.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @since 2021-11-29 13:53
 */
public class BuildTree07 {
  private Map<Integer, Integer> indexMap;

  /**
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 94.66% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 27.48% 的用户
   *
   * @param preorder 前序遍历
   * @param inorder 中序遍历
   * @param preorder_left 前序遍历根左边界
   * @param preorder_right 前序遍历根右边界
   * @param inorder_left 中序遍历左边界
   * @param inorder_right 中序遍历右边界
   * @return
   */
  public TreeNode myBuildTree(
      int[] preorder,
      int[] inorder,
      int preorder_left,
      int preorder_right,
      int inorder_left,
      int inorder_right) {

    // 如果左边界超过右边界，返回null
    if (preorder_left > preorder_right) {
      return null;
    }

    // 前序遍历中的第一个节点就是根节点
    int preorder_root = preorder_left;
    // 在中序遍历中定位根节点
    int inorder_root = indexMap.get(preorder[preorder_root]);

    // 先把根节点建立出来
    TreeNode root = new TreeNode(preorder[preorder_root]);
    // 得到左子树中的节点数目
    int size_left_subtree = inorder_root - inorder_left;
    // 递归地构造左子树，并连接到根节点
    // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    root.left =
        myBuildTree(
            preorder,
            inorder,
            preorder_left + 1,
            preorder_left + size_left_subtree,
            inorder_left,
            inorder_root - 1);
    // 递归地构造右子树，并连接到根节点
    // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
    root.right =
        myBuildTree(
            preorder,
            inorder,
            preorder_left + size_left_subtree + 1,
            preorder_right,
            inorder_root + 1,
            inorder_right);
    return root;
  }

  /**
   * 分治-递归
   *
   * @param preorder 前序遍历
   * @param inorder 中序遍历
   * @return
   */
  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    int n = preorder.length;
    // 构造哈希映射，帮助我们快速定位根节点
    indexMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      indexMap.put(inorder[i], i);
    }
    return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  /**
   * 迭代 <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 94.66% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 97.91% 的用户
   *
   * @param preorder
   * @param inorder
   * @return
   */
  public TreeNode buildTree2(int[] preorder, int[] inorder) {
    // 处理空树
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    // 树根root为前序遍历的首个元素
    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    int inorderIndex = 0;
    // 前序遍历，从根节点root开始，只要有左子节点，就一直会往左下方走，直到最左下角。
    // 中序遍历，是从最左下角往上，如果碰到节点有右子节点，则会转向。
    for (int i = 1; i < preorder.length; i++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        // 如果两个值不相等，说明前序遍历还有左节点
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
      } else {
        // 到达了左下角，这时就需要往上走并处理右子树。
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex++;
        }
        node.right = new TreeNode(preorderVal);
        stack.push(node.right);
      }
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
