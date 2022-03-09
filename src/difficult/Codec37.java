package difficult;

import struct.TreeNode;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请实现两个函数，分别用来序列化和反序列化二叉树。
 *     你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列/反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为 一个字符串并且将这个字符串反序列化为原始的树结构。
 *     提示：输入输出格式与LeetCode目前使用的方式一致，详情请参 阅LeetCode序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * @since 2021-12-07 09:33
 */
public class Codec37 {
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    StringBuilder s = new StringBuilder();
    s.append(root.val);
    s.append(" ");
    s.append(serialize(root.left));
    s.append(" ");
    s.append(serialize(root.right));
    return s.toString();
  }

  public TreeNode deserialize(String data) {

    String[] strs = data.split(" ");
    TreeNode root = deserialize(strs, new int[] {0});
    return root;
  }

  public TreeNode deserialize(String[] strs, int[] i) {
    if (strs.length <= i[0] || strs[i[0]].equals("#")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(strs[i[0]]));
    i[0]++;
    node.left = deserialize(strs, i);
    i[0]++;
    node.right = deserialize(strs, i);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
