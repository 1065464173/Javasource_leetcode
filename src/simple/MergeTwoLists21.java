package simple;

import struct.ListNode;

/**
 * @program: JavaSE_learning
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author: Sxuet
 * @create: 2021-06-09 10:57
 */
public class MergeTwoLists21 {
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists2(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists2(l2.next, l1);
      return l2;
    }
  }

  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    ListNode preHead = new ListNode(-1);
    ListNode preList = preHead;
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        preList.next = l1;
        l1 = l1.next;
      } else {
        preList.next = l2;
        l2 = l2.next;
      }
      preList = preList.next;
    }
    // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
    preList.next = (l1 == null) ? l2 : l1;
    return preHead.next;
  }
}

// class ListNode {
//  int val;
//  ListNode next;
//
//  ListNode() {}
//
//  ListNode(int val) {
//    this.val = val;
//  }
//
//  ListNode(int val, ListNode next) {
//    this.val = val;
//    this.next = next;
//  }
// }
