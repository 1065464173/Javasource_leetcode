package cxymsjd6.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构 Setofstacks，模拟这种行为。 *
 * Setofstacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外， Setofstacks.push（）和 Setofstacks *
 * .pop（）应该与普通栈的操作方法相同（也就是说，pop（）返回的值，应该跟只有一个栈时的情況一样）。进阶：实现popat（ * int index）方法，根据指定的子栈，执行pop操作。
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop， popat应返回-1
 *
 * @author Sxuet
 * @program daydayup
 * @description
 * @since 2021-12-30 15:45
 */
public class StackOfPlates0303 {
  /** 执行用时： 10 ms , 在所有 Java 提交中击败了 93.84% 的用户 内存消耗： 46.1 MB , 在所有 Java 提交中击败了 49.58% 的用户 */
  LinkedList<Stack<Integer>> stackList = new LinkedList<>();

  int cap;

  public StackOfPlates0303(int cap) {
    this.cap = cap;
  }

  public void push(int val) {
    if (cap <= 0) return;
    Stack<Integer> stack;
    if (stackList.size() == 0) {
      stack = new Stack<>();
      stackList.add(stack);
    }
    stack = stackList.getLast();
    if (stack.size() >= cap) {
      stack = new Stack<>();
      stackList.add(stack);
    }
    stack.push(val);
  }

  public int pop() {
    if (stackList.size() == 0) return -1;
    Stack<Integer> stack = stackList.getLast();
    int result = stack.pop();
    if (stack.isEmpty()) {
      stackList.remove(stack);
    }
    return result;
  }

  public int popAt(int index) {
    if (index + 1 > stackList.size()) return -1;
    Stack<Integer> stack = stackList.get(index);
    int result = stack.pop();
    if (stack.isEmpty()) {
      stackList.remove(stack);
    }
    return result;
  }
}
/*
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
