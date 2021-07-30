package simple;

import struct.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: Javasource_leetcode
 * @description: 请判断一个链表是否为回文链表 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author: Sxuet
 * @create: 2021-08-08 20:22
 */
public class IsPalindrome234 {
  /**
   * 递归 使空间复杂度降为O(n) 时间复杂度仍为O(n) 由于栈的的开销很大，所以比第二种方法可能差一些——具体看不同语言的底层实现
   *
   * <p>currentNode 指针是先到尾节点，由于递归的特性再从后往前进行比较。frontPointer 是递归函数外的指针。若 currentNode.val !=
   * frontPointer.val 则返回 false。反之，frontPointer 向前移动并返回 true。
   *
   * <p>算法的正确性在于递归处理节点的顺序是相反的（回顾上面打印的算法），而我们在函数外又记录了一个变量，因此从本质上，我们同时在正向和逆向迭代匹配。
   *
   * @param head
   * @return
   */
  private ListNode frontPointer;

  /**
   * 自创垃圾写法 状态：通过 执行用时: 15 ms 内存消耗: 56.7 MB 提交时间：7 分钟前
   *
   * @param head
   * @return
   */
  public boolean isPalindrome1(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    ArrayList<Integer> temp = new ArrayList<>(list);
    Collections.reverse(list);
    return temp.equals(list);
  }

  /**
   * 将值复制到数组列表中，使用双指针判断
   *
   * <p>执行用时： 7 ms , 在所有 Java 提交中击败了 54.35% 的用户 内存消耗： 50.4 MB , 在所有 Java 提交中击败了 45.84% 的用户
   *
   * <p>时间复杂度O(3/2*n)=O(n)遍历两次，空间复杂度O(n) 元素个数
   *
   * @param head
   * @return
   */
  public boolean isPalindrome2(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
      if (!list.get(i).equals(list.get(j))) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome3(ListNode head) {
    frontPointer = head;
    return recursivelyCheck(head);
  }

  private boolean recursivelyCheck(ListNode currentNode) {
    if (currentNode != null) {
      if (!recursivelyCheck(currentNode.next)) {
        return false;
      }
      if (currentNode.val != frontPointer.val) {
        return false;
      }
      frontPointer = frontPointer.next;
    }
    return true;
  }

  /**
   * 官方的快慢指针 避免O(n)空间的方法就是改变输入
   *
   * <p>时间复杂度O(n)，空间复杂度O(1) <br>
   * 执行用时： 6 ms , 在所有 Java 提交中击败了 64.19% 的用户 内存消耗： 48.2 MB , 在所有 Java 提交中击败了 85.74% 的用户
   *
   * <p>算法流程：<br>
   * 1.找到前半部分的尾节点<br>
   * 2.反转后半部分链表<br>
   * 3.判断是否回文<br>
   * 4.恢复链表<br>
   * 5.返回结果
   *
   * @param head
   * @return
   */
  public boolean isPalindrome4(ListNode head) {
    if (head == null) {
      return true;
    }
    // 1.找到前半部分的尾节点
    ListNode firstHalfEnd = endOfFirstHalf(head);
    // 2.反转后半部分链表
    ListNode secondHalfStart = reverseList(firstHalfEnd);

    // 3.判断是否回文
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean res = true;
    while (res && p2 != null && p1 != null) {
      if (p1.val != p2.val) {
        res = false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }
    // 4、5 恢复链表返回结果
    firstHalfEnd.next = reverseList(secondHalfStart);
    return res;
  }

  private ListNode endOfFirstHalf(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  /**
   * 大佬的快慢指针
   *
   * <p>执行用时： 3 ms , 在所有 Java 提交中击败了 99.99% 的用户 内存消耗： 48 MB , 在所有 Java 提交中击败了 93.94% 的用户
   *
   * @param head
   * @return
   */
  public boolean isPalindrome5(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    // 初始化快指针和慢指针
    ListNode slow = head, fast = head;
    // pre记录slow的前一个值。prepre记录pre反转的值
    ListNode pre = head, prepre = null;
    // 遍历链表直到链尾
    while (fast != null && fast.next != null) {
      // 记录slow的前一个值
      pre = slow;
      // slow后移一步
      slow = slow.next;
      // fast后移两步
      fast = fast.next.next;
      pre.next = prepre;
      prepre = pre;
    }
    // 若fast为链尾，则链表长度为奇数。若fast为null，长度为偶数
    if (fast != null) {
      // 长度为奇数时slow取中位数
      slow = slow.next;
    }
    // pre将依据prepre的反转遍历前半部分反转的结果，slow遍历后半段
    while (pre != null && slow != null) {
      // 遇到值不同则不为回文
      if (pre.val != slow.val) {
        return false;
      }
      pre = pre.next;
      slow = slow.next;
    }
    return false;
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
