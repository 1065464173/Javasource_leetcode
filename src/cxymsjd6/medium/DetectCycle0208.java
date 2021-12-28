package cxymsjd6.medium;

import struct.ListNode;

import java.util.HashSet;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 *
 * <p>如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果
 * pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * @author Sxuet
 * @since 2021/12/28 11:15
 */
public class DetectCycle0208 {
  /**
   * 使用hashset记录每个节点，一旦又重复就是进入了循环。<br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 34.11% 的用户 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 11.77% 的用户
   *
   * @param head
   * @return
   */
  public ListNode detectCycle1(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      if (!set.add(head)) {
        return head;
      }
      head = head.next;
    }
    return null;
  }

  /**
   * 进阶：你是否可以不用额外空间解决此题？<br>
   * 解决思路：快慢指针，如果有循环的话，快慢指针一定环内会相遇。 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow
   * 每次向后移动一个位置。最终，它们会在入环点相遇。
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 88.60% 的用户
   *
   * @param head
   * @return
   */
  public ListNode detectCycle2(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }
      if (fast == slow) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }
}
/*
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
