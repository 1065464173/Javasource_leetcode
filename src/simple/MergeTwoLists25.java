package simple;

import struct.ListNode;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @since 2021-11-21 13:23
 */
public class MergeTwoLists25 {
  /**
   * 双指针实现<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 81.56% 的用户 <br>
   * 官方的双指针 和我的思路一样，实现的比我更简单，他的更简洁 。 内存消耗更少
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    ListNode node = new ListNode();
    ListNode ans = node;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        node.next = l2;
        l2 = l2.next;
      } else {
        node.next = l1;
        l1 = l1.next;
      }
      node = node.next;
    }
    node.next = l1 == null ? l2 : l1;
    return ans.next;
  }
}
