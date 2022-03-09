package cxymsjd6.medium;

import struct.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * <p>这些数位是反向存放的，也就是个位排在链表首部。
 *
 * <p>编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * @author Sxuet
 * @since 2021/12/24 9:54
 */
public class AddTwoNumbers0205 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0);
    ListNode ans = node;
    int c = 0;
    while (l1 != null || l2 != null||c!=0) {
      int i = 0;
      if (l1 != null) {
        i += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        i += l2.val;
        l2 = l2.next;
      }
      i += c;
      c = i / 10;
      node.next = new ListNode(i % 10);
      node = node.next;
    }
    return ans.next;
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
