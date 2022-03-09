package cxymsjd6.simple;

import org.omg.CosNaming.NameHelper;
import struct.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * @author sxuet
 * @since 2021/12/23 9:55
 */
public class KthToLast0202 {
  private  int res = 0;

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 7.96% 的用户
   *
   * @param head
   * @param k
   * @return
   */
  public int kthToLast1(ListNode head, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    while (head!=null){
      list.add(head.val);
      head= head.next;
    }
    return list.get(list.size()-k);
  }

  /**
   * 双指针！！！！<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 38.36% 的用户
   *
   * @param head
   * @param k
   * @return
   */
  public int kthToLast2(ListNode head, int k) {
    ListNode slow = head, fast = head;
    while (k > 0) {
      fast = fast.next;
      k--;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow.val;
  }
}
