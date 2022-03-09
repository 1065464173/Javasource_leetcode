package simple;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Javasource_leetcode
 * @description: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @author: Sxuet
 * @create: 2021-07-20 22:21
 */
public class GetIntersectionNode160 {
  /**
   * 自创的暴力解法 时间复杂度O(n^2)
   *
   * @param headA
   * @param headB
   * @return 交点ListNode
   */
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode a = headA;
    ListNode b = headB;
    while (a != null) {
      while (b != null) {
        if (a.equals(b)) {
          return a;
        }
        b = b.next;
      }
      a = a.next;
      b = headB;
    }
    return null;
  }

  /**
   * 哈希集合 时间复杂度O(n+m) 空间复杂度O(m) m 是A 的长度，需要储存A的所有节点
   *
   * @param headA
   * @param headB
   * @return 交点ListNode
   */
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    Set<ListNode> set = new HashSet<>();
    ListNode temp = headA;
    while (temp != null) {
      set.add(temp);
      temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
      if (set.contains(temp)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  /**
   * 巧妙！
   *
   * <p>双指针 将空间复杂符降为O(1)
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode a = headA, b = headB;
    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }
}
