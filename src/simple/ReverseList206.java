package simple;

import struct.ListNode;

/**
 * @program: Javasource_leetcode
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author: Sxuet
 * @create: 2021-08-01 20:34
 */
public class ReverseList206 {
  /**
   * 递归时间复杂度： O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
   *
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList1(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  /**
   * 双指针——迭代。时间复杂度O(n)空间1
   *
   * @param head
   * @return
   */
  public ListNode reverseList2(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }
}
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
