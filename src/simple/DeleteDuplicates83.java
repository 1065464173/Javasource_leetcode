package simple;

import struct.ListNode;

/**
 * @program: Javasource_leetcode
 * @description: 存在一个按升序排列的链表，给你这个链表的头节点 head
 *     <p>请你删除所有重复的元素，使每个元素 只出现一次 返回同样按升序排列的结果链表。
 * @author: Sxuet
 * @create: 2021-07-04 21:21
 */
public class DeleteDuplicates83 {

  public void test() {
    ListNode l4 = new ListNode(3);
    ListNode l3 = new ListNode(3, l4);
    ListNode l2 = new ListNode(3, l3);
    ListNode l1 = new ListNode(2, l2);
    ListNode head = new ListNode(1, l1);

    deleteDuplicates(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

  /**
   * 时间复杂度： O ( n ) O(n)
   *
   * <p>其中 n n 是链表的长度。 空间复杂度： O ( 1 ) O(1)。
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  private void deleteNode(ListNode current) {
    current.next = current.next.next;
  }
}
// class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {}
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
// }
