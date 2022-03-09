package simple;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *     例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * @since 2021-11-20 13:02
 */
public class GetKthFromEnd22 {
  /**
   * 栈实现：弊端，记录每个链表及其子链表的指针，遍历到最后后再pop出倒数第k个元素
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode getKthFromEnd1(ListNode head, int k) {
    Deque<ListNode> stack = new LinkedList<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    while (k != 1) {
      stack.pop();
      k--;
    }
    return stack.pop();
  }

  /**
   * 双指针<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 48.16% 的用户
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode getKthFromEnd2(ListNode head, int k) {
    int size = 0;
    ListNode left = head;
    while (head != null) {
      if (size > k) {
        left = left.next;
      } else {
        size++;
      }
      head = head.next;
    }
    return left;
  }
}
