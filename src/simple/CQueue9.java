package simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail
 *     和deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。（若队列中没有元素，deleteHead操作返回-1)
 * @since 2021-11-10 10:21
 */
public class CQueue9 {
  /*
   * stackIn只负责进入<br>
   * stackOut只负责取出<br>
   * 只有stackOut为空时把stackIn全部倾倒入stackOut<br>
   * 执行用时： 42 ms , 在所有 Java 提交中击败了 78.18% 的用户 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 89.37% 的用户
   */
  Deque<Integer> stackIn = null;

  Deque<Integer> stackOut = null;

  public CQueue9() {
    stackIn = new LinkedList<>();
    stackOut = new LinkedList<>();
  }

  public void appendTail(int value) {
    stackIn.add(value);
  }

  public int deleteHead() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.add(stackIn.pop());
      }
    }
    return stackOut.isEmpty() ? -1 : stackOut.pop();
  }
}

/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
