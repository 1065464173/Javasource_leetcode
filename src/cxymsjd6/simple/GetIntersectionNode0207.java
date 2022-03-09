package cxymsjd6.simple;

import struct.ListNode;

/**
 * @author Sxuet
 * @since 2021/12/27 14:18
 */
public class GetIntersectionNode0207 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 45.27% 的用户
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode nodeA = headA, nodeB = headB;
    while (headA != headB) {
      headA = headA == null ? nodeB : headA.next;
      headB = headB == null ? nodeA : headB.next;
    }
    return headA;
  }
}
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
