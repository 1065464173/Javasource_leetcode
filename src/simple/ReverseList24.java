package simple;

import struct.ListNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @since 2021-11-11 10:21
 */
public class ReverseList24 {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
