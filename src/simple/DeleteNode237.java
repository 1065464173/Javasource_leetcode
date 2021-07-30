package simple;

import struct.ListNode;

/**
 * @program: Javasource_leetcode
 * @description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * @author: Sxuet
 * @create: 2021-08-11 20:40
 */
public class DeleteNode237 {
  static ListNode head = new ListNode();

  /**
   * 时间和空间O(1)
   *
   * @param node
   */
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
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
