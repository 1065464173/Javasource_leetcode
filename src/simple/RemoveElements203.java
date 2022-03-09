package simple;

import struct.ListNode;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author: Sxuet
 * @create: 2021-07-30 20:03
 */
public class RemoveElements203 {
  /**
   * 递归删除 时间复杂度：O(n)，其中 n 是链表的长度。递归过程中需要遍历链表一次。 空间复杂度：O(n)，其中 n n 是链表的长度。空间复杂度主要取决于递归调用栈，最多不会超过 n 层。
   *
   * @param head
   * @param val
   * @return
   */
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
  }

  /**
   * 迭代 时间O(n) 空间O(1)
   *
   * @param head
   * @param val
   * @return
   */
  public ListNode removeElements1(ListNode head, int val) {
    // 由于链表的头节点有可能被删除，所以创建哑节点。使其变成头节点
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null) {
      if (temp.next.val == val) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return dummyHead.next;
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
