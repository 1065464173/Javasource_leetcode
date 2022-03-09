package simple;

import java.util.Stack;

/**
 * @program: Javasource_leetcode
 * @description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *     <p>push(x) —— 将元素 x 推入栈中。
 *     <p>pop()—— 删除栈顶的元素。
 *     <p>top()—— 获取栈顶元素。
 *     <p>getMin() —— 检索栈中的最小元素。
 * @author: Sxuet
 * @create: 2021-07-19 15:00
 */
public class MinStack155 {
  // 数据栈
  private Stack<Integer> data;
  // 辅助栈
  private Stack<Integer> helper;

  public MinStack155() {
    data = new Stack<>();
    helper = new Stack<>();
  }

  public void push(int val) {
    data.push(val);
    if (helper.isEmpty() || helper.peek() >= val) {
      helper.push(val);
    }
  }

  public void pop() {
    if (!data.isEmpty()) {
      int top = data.pop();
      if (top == helper.peek()) {
        helper.pop();
      }
    }
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return helper.peek();
  }
}
