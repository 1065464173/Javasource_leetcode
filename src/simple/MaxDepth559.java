package simple;

import struct.Node;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description
 * @since 2021-11-08 10:55
 */
public class MaxDepth559 {

  /**
   * 寻找树的最大深度<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 36.38% 的用户
   *
   * @param root
   * @return
   */
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int maxi = 1;
    // 找出所有子树中最高的那个的长度
    for (Node item : root.children) {
      // 树的长度等于最高的子树的长度+1,如果没有子树，则返回自身深度为1
      maxi = Math.max(maxi, maxDepth(item) + 1);
    }
    return maxi;
  }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
