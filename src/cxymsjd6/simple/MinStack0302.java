package cxymsjd6.simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * @author Sxuet
 * @since 2021/12/29 9:42
 */
public class MinStack0302 {

  PriorityQueue<Integer> queue;
  Deque<Integer> stack;
  /** initialize your data structure here. */
  public MinStack0302() {
    queue = new PriorityQueue<>();
    stack = new LinkedList<>();
  }

  public void push(int x) {
    stack.push(x);
    queue.offer(x);
  }

  public void pop() {
    queue.remove(stack.poll());
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return queue.peek();
  }
}
/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
