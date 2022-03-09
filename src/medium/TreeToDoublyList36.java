package medium;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @since 2021-11-24 14:51
 */
public class TreeToDoublyList36 {
  TreeNode pre, head;

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 16.60% 的用户
   *
   * @param root
   * @return
   */
  public TreeNode treeToDoublyList(TreeNode root) {
    if (root == null) {
      return null;
    }
    dfs(root);
    // 进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
    head.left = pre;
    pre.right = head;
    return root;
  }

  private void dfs(TreeNode cur) {
    if (cur == null) {
      return;
    }
    dfs(cur.left);
    // pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,
    if (pre == null) {
      // 当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
      head = cur;
    } else {
      // 反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
      pre.right = cur;
    }
    // pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
    cur.left = pre;
    // pre 指向当前cur
    pre = cur;
    dfs(cur.right);
  }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
