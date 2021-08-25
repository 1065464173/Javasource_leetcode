package simple;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-08-15 13:47
 */
public class BinaryTreePaths257 {
  /**
   * 深度优先搜索 时间O(n^2) 时间O(n^2)<br>
   * 当前节点不是叶子节点就继续遍历，是则添加路径<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 73.66% 的用户
   *
   * @param root
   * @return
   */
  public List<String> binaryTreePaths1(TreeNode root) {
    List<String> list = new ArrayList<>();
    getPath(root, "", list);
    return list;
  }

  public void getPath(TreeNode root, String path, List<String> list) {
    if (root != null) {
      StringBuilder p = new StringBuilder(path);
      p.append(Integer.toString(root.val));
      // 如果是叶子节点，添加路径
      if (root.right != null && root.left != null) {
        list.add(p.toString());
      } else {
        p.append("->");
        getPath(root.right, p.toString(), list);
        getPath(root.left, p.toString(), list);
      }
    }
  }

  /**
   * 广度优先搜索 时间空间同上
   *
   * <p>维护一个队列，存储节点以及根到该节点的路径。<br>
   * 一开始这个队列里只有根节点。在每一步迭代中，我们取出队列中的首节点，<br>
   * 如果它是叶子节点，则将它对应的路径加入到答案中。如果它不是叶子节点，则将它的所有孩子节点加入到队列的末尾。<br>
   * 当队列为空时广度优先搜索结束，我们即能得到答案。
   *
   * @param root
   * @return
   */
  public List<String> binaryTreePaths2(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if (root == null) {
      return paths;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<String> pathQueue = new LinkedList<>();
    nodeQueue.offer(root);
    pathQueue.offer(Integer.toString(root.val));

    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      String path = pathQueue.poll();

      if (node.left == null && node.right == null) {
        paths.add(path);
      } else {
        if (node.left != null) {
          nodeQueue.offer(node.left);
          pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
        }

        if (node.right != null) {
          nodeQueue.offer(node.right);
          pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
        }
      }
    }
    return paths;
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
