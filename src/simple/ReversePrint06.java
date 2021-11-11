package simple;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @since 2021-11-11 09:37
 */
public class ReversePrint06 {

  /**
   * stack 记录
   *
   * @param head
   * @return
   */
  public int[] reversePrint1(ListNode head) {
    Deque<Integer> stack = new LinkedList<>();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int[] ans = new int[stack.size()];
    int i = 0;
    while (!stack.isEmpty()) {
      ans[i++] = stack.pop();
    }
    return ans;
  }

  /**
   * 评论区的答案和我差不多，但是分数更高一点，可以借鉴一下<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 67.34% 的用户
   *
   * @param head
   * @return
   */
  public int[] reversePrint2(ListNode head) {
    // 先获取链表长度，创建对应长度数组
    ListNode currNode = head;
    int len = 0;
    while (currNode != null) {
      len++;
      currNode = currNode.next;
    }
    int[] result = new int[len];

    // 再次遍历链表，将值倒序填充至结果数组
    currNode = head;
    while (currNode != null) {
      result[len - 1] = currNode.val;
      len--;
      currNode = currNode.next;
    }
    return result;
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
