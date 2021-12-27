package cxymsjd6.simple;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * @author Sxuet
 * @since 2021/12/24 17:06
 */
public class IsPalindrome0206 {
  /**
   * 执行用时： 5 ms , 在所有 Java 提交中击败了 7.97% 的用户 内存消耗： 42.3 MB , 在所有 Java 提交中击败了 18.94% 的用户
   *
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {
    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();
    int size = 0;
    while (head != null) {
      stack1.push(head.val);
      head = head.next;
      size++;
    }
    for (int i = 0; i < size >> 1; i++) {
      stack2.push(stack1.poll());
    }
    if ((size & 1) == 1) {
      stack1.poll();
    }
    return stack2.equals(stack1);
  }

  /**
   * 在原有链表上操作 空间降到O(1) <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 41 MB , 在所有 Java 提交中击败了 71.22% 的用户
   *
   * @param head
   * @return
   */
  public boolean isPalindrome2(ListNode head) {
    int size = 0;
    ListNode node = head;
    while (head != null) {
      head = head.next;
      size++;
    }
    ListNode temp = null;
    for (int i = 0; i < size / 2; i++) {
      ListNode next = node.next;
      node.next = temp;
      temp = node;
      node = next;
    }
    if ((size & 1) == 1) {
      node = node.next;
    }
    while (node != null) {
      if (node.val != temp.val) {
        return false;
      }
      node = node.next;
      temp = temp.next;
    }
    return true;
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
