package simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * @author: Sxuet
 * @create: 2021-08-04 21:14
 */
public class MyStack225 {
  // 队列先进先出
  Queue<Integer> q1;
  Queue<Integer> q2;

  public MyStack225() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    // 队列的offer不会抛IllegalStateException异常，添加失败就返回false，add会抛异常。

    /** 使用两个队列实现，入栈时间复杂度为O(n) */
    /*q2.offer(x);
    while (!q1.isEmpty()) {
      // remove方法和poll方法都是删除队列的头元素，remove方法在队列为空的情况下将抛异常，而poll方法将返回null；
      q2.offer(q1.poll());
    }
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;*/

    /** 使用一个队列实现 入栈时间复杂度也是O(n) */
    q1.offer(x);
    for (int i = 0; i < q1.size(); i++) {
      q1.offer(q1.poll());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return q1.isEmpty() ? null : q1.remove();
  }

  /** Get the top element. */
  public int top() {
    return q1.isEmpty() ? null : q1.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q1.isEmpty();
  }
}
/*
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
