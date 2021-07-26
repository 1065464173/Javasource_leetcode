package simple;

import struct.ListNode;

import java.util.HashSet;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个链表，判断链表中是否有环。
 *     <p>如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *     如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *     <p>如果链表中存在环，则返回 true 。 否则，返回 false 。
 * @author: Sxuet
 * @create: 2021-07-17 22:19
 */
public class HasCycle141 {
  /**
   * 哈希表记录
   *
   * <p>时间复杂度O(n)
   *
   * <p>空间复杂度O(n) 哈希表的开销
   *
   * @param head
   * @return
   */
  public boolean hasCycle1(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      if (!set.add(head)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  /**
   * 快慢指针本方法 将空间复杂度降到O(1)
   *
   * <p>需要读者对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解。
   *
   * <p>假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。
   *
   * <p>当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；
   *
   * <p>如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。
   *
   * <p>等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈
   *
   * @param head
   * @return
   */
  public boolean hasCycle2(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
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
