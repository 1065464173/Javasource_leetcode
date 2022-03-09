package medium;

import struct.TreeNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入两棵二叉树A和B，判断B是不是A的子结构。（约定空树不是任意一个树的子结构） B是A的子结构，即A中有出现和B相同的结构和节点值。
 * @since 2021-11-16 14:56
 */
public class IsSubStructure26 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 56.62% 的用户
   *
   * @param A
   * @param B
   * @return
   */
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    return (A != null && B != null)
        && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
  }

  /**
   * 终止条件：<br>
   * 1.当节点B为空：说明树B已匹配完成（越过叶子节点），因此返回true；<br>
   * 2.当节点A为空：说明已经越过树A叶子节点，即匹配失败，返回false；<br>
   * 3.当节点A和B的值不同：说明匹配失败，返回false;
   */
  boolean recur(TreeNode A, TreeNode B) {
    if (B == null) {
        return true;
    }
    if (A == null || A.val != B.val) {
        return false;
    }
    return recur(A.left, B.left) && recur(A.right, B.right);
  }
}
