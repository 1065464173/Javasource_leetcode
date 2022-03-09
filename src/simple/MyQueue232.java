package simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Javasource_leetcode
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *     <p>实现 MyQueue 类：
 *     <p>void push(int x) 将元素 x 推到队列的末尾 int pop() 从队列的开头移除并返回元素 int peek() 返回队列开头的元素 boolean
 *     empty() 如果队列为空，返回 true ；否则，返回 false
 * @author: Sxuet
 * @create: 2021-08-07 21:59
 */
/**
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 38.65% 的用户
 *
 * <p>时间复杂度push 和 empty 为O(1) pop 和 peek 为O(1)<br>
 * 空间复杂度O(n)
 */
public class MyQueue232 {
  Deque<Integer> inStack = null;
  Deque<Integer> outStack = null;

  public MyQueue232() {
    // 实现先进先出
    inStack = new LinkedList<>();
    outStack = new LinkedList<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    inStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (outStack.isEmpty()) {
      in2out();
    }
    return outStack.pop();
  }

  private void in2out() {
    while (!inStack.isEmpty()) {
      outStack.push(inStack.pop());
    }
  }

  /** Get the front element. */
  public int peek() {
    if (outStack.isEmpty()) {
      in2out();
    }
    return outStack.pop();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }
}
/*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
