package simple;

import struct.ListNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入两个链表，找出它们的第一个公共节点。
 * @since 2021-11-21 13:50
 */
public class GetIntersectionNode52 {
  /**
   * 双指针 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 24.01% 的用户
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA;
    ListNode pB = headB;
    // 终止条件为遍历到pa和p2的公共节点，或者pa、pb同时==null
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
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
