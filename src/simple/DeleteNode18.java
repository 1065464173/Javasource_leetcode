package simple;

import struct.ListNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 返回删除后的链表的头节点。注意：此题对比原题有改动
 * @since 2021-11-20 12:27
 */
public class DeleteNode18 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 21.37% 的用户
   *
   * @param head
   * @param val
   * @return
   */
  public ListNode deleteNode(ListNode head, int val) {
    ListNode node = head;
    ListNode pre = new ListNode();
    pre.next = node;
    while (node != null) {
      if (node.val == val) {
        if (head == node) {
          return head.next;
        }
        pre.next = node.next;
        return head;
      }
      pre = node;
      node = node.next;
    }
    return head;
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
