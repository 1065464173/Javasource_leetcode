package medium;

import liquibase.pro.packaged.I;
import liquibase.pro.packaged.Q;

import java.util.*;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请定义一个队列并实现函数max value得到队列里的最大值，要求函数max_value、push_back和pop_front的均摊时间复杂度都是 O(1)。
 *     若队列为空，pop front和max value需要返回-1
 * @since 2021-12-06 10:22
 */
public class MaxQueueII59 {
  /**
   * 我笑了…… <br>
   * 执行用时： 38 ms , 在所有 Java 提交中击败了 8.15% 的用户 内存消耗： 46.6 MB , 在所有 Java 提交中击败了 5.01% 的用户
   */
  PriorityQueue<Integer> priorityQueue;

  Deque<Integer> deque;

  public MaxQueueII59() {
    priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
    deque = new LinkedList<>();
  }

  public int max_value() {
    if (deque.isEmpty()) {
      return -1;
    }
    return priorityQueue.peek();
  }

  public void push_back(int value) {
    deque.offerLast(value);
    priorityQueue.offer(value);
  }

  public int pop_front() {
    if (deque.isEmpty()) {
      return -1;
    }
    Integer integer = deque.pollFirst();
    priorityQueue.remove(integer);
    return integer;
  }
}

/*
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
