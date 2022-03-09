package simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数在该栈中，调用min、push及pop的时间复杂度都是0（1）。
 * @since 2021-11-10 11:05
 */
/** 执行用时： 19 ms , 在所有 Java 提交中击败了 28.22% 的用户 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 5.28% 的用户 */
public class MinStack30 {
  /**
   * stack - 存储栈 <br>
   * order - 辅助栈，记录最小值
   */
  Deque<Integer> stack, order;

  public MinStack30() {
    stack = new LinkedList<>();
    order = new LinkedList<>();
  }

  public void push(int x) {
    stack.push(x);
    if (order.isEmpty() || order.element() >= x) {
      order.push(x);
    }
  }

  public void pop() {
    if (stack.pop().equals(order.element())) {
      order.pop();
    }
  }

  public int top() {
    return stack.element();
  }

  public int min() {
    return order.element();
  }
}

/*
MinStack minStack = new MinStack();
minStack.push(-2);
minStack push(0);
minStack.push(-3);
minStack.min();一》返回-3.
minStack.pop();
minStack.top();一》返回0.
minStack.min();一》返回-2.

各函数的调用总次数不超过 20000 次
 */
