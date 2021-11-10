package medium;

import struct.ListNode;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *     请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字0之外，这两个数都不会以0开头。
 * @since 2021-11-09 10:33
 */
public class AddTwoNumbers2 {
  /**
   * 一位一位的加，并记录进位<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 93.16% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 47.41% 的用户
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode();
    ListNode node = ans;
    // 进位
    int c1 = 0;
    while (l1 != null || l2 != null) {
      int i = 0;
      if (l1 != null) {
        i += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        i += l2.val;
        l2 = l2.next;
      }
      i += c1;
      node.next = new ListNode(i % 10);
      c1 = i / 10;
      node = node.next;
    }
    //最后的进位不能忘
    if (c1 > 0) {
      node.next = new ListNode(c1);
    }
    return ans.next;
  }
}
