package medium;

import java.util.Stack;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列{1，2，3，4，5}是某栈的压栈序列，序列{4，5，3，2，1}是该压栈序列对应的一个弹出序列，但{4，3，5，1，2}就不可能是该压栈序列的弹出序列。
 * @since 2021-12-04 14:32
 */
public class ValidateStackSequences31 {

  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.33% 的用户 内存消耗： 38 MB , 在所有 Java 提交中击败了 70.04% 的用户
   *
   * @param pushed
   * @param popped
   * @return
   */
  public static boolean validateStackSequences1(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int p1 = 0, p2 = 0;
    while (p1 < pushed.length && p2 < popped.length ) {
      while (p1 < pushed.length && pushed[p1] != popped[p2]) {
        stack.add(pushed[p1++]);
      }
      p2++;
      p1++;
      while (p2 < popped.length &&!stack.isEmpty()&&stack.peek() == popped[p2]) {
        stack.pop();
        p2++;
      }
    }
    return p1==pushed.length&&p2==popped.length;
  }

  /**
   * k神精选 感觉比我的实现起来更简约，易懂，但是不知道为啥 时间、空间没我好？？<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 85.20% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 27.86% 的用户
   *
   * @param pushed
   * @param popped
   * @return
   */
  public boolean validateStackSequences2(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    for(int num : pushed) {
      // num 入栈
      stack.push(num);
      // 循环判断与出栈
      while(!stack.isEmpty() && stack.peek() == popped[i]) {
        stack.pop();
        i++;
      }
    }
    return stack.isEmpty();
  }
}
