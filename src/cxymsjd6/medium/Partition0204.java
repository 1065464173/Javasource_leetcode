package cxymsjd6.medium;

import struct.ListNode;

/**
 * @author Sxuet
 * @since 2021/12/23 14:25
 */
public class Partition0204 {
  /**
   * 维护两个两个链表，一个放小的数一个放大的数，最后<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 28.11% 的用户
   *
   * @param head
   * @param x
   * @return
   */
  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode(0);
    ListNode smallHead = small;
    ListNode large = new ListNode(0);
    ListNode largeHead = large;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    large.next = null;
    small.next = largeHead.next;
    return smallHead.next;
  }
}
