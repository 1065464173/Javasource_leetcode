package medium;

import java.util.Stack;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @since 2021-11-29 18:51
 */
public class VerifyPostorder33 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 43.56% 的用户
   *
   * @param postorder 后序遍历 - 左右根
   * @return true/false
   */
  public boolean verifyPostorder1(int[] postorder) {
    return recur(postorder, 0, postorder.length - 1);
  }

  private boolean recur(int[] postorder, int i, int j) {
    if (i >= j) return true;
    int p = i;
    while (postorder[p] < postorder[j]) p++;
    int m = p;
    while (postorder[p] > postorder[j]) p++;
    return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
  }

  public boolean verifyPostorder2(int[] postorder) {
    Stack<Integer> stack = new Stack<>();
    int root = Integer.MAX_VALUE;
    // 倒序遍历-根右左。可把树的根节点看为此无穷大节点的左孩子）
    for (int i = postorder.length - 1; i >= 0; i--) {
      // 如果节点值大于root，不符合搜索二叉树定义
      if (postorder[i] > root) {
        return false;
      }
      while (!stack.isEmpty() && stack.peek() > postorder[i]) {
        root = stack.pop();
      }
      // 添加节点
      stack.add(postorder[i]);
    }
    return true;
  }
}
