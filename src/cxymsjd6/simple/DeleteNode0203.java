package cxymsjd6.simple;

import struct.ListNode;

/**
 * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
 *
 * <p>假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 *
 * <p>例如，传入节点c（位于单向链表a->b->c->d->e->f中），将其删除后，剩余链表为a->b->d->e->f
 *
 * @author Sxuet
 * @since 2021/12/23 14:04
 */
public class DeleteNode0203 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 60.61% 的用户
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
