package struct;

import java.util.List;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description
 * @since 2021-11-08 10:55
 */
public class Node {
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
}
;
