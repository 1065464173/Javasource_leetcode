package simple;

import java.util.ArrayList;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 *     <p>实现 MovingAverage 类：
 *     <p>MovingAverage(int size) 用窗口大小 size 初始化对象。 double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。
 * @author: Sxuet
 * @create: 2021-08-31 22:06
 */
public class MovingAverage346 {

  /**
   * 方法一：数组或列表<br>
   * 用数组或列表来记录所有传入的值。然后从中取出对应的元素来计算平均值 <br>
   * 时间 O(N) N是移动窗口的大小 空间O(M) M是queue的大小
   *
   * <p>方法二：双端队列<br>
   * 并不需要存储数据流中的所有值，只需要数据流中的最后 n 个值。 <br>
   * 我们向窗口添加一个新元素，同时从窗口中删除第一个元素。 <br>
   * 时间O(1) 空间O(N) 移动窗口的大小
   *
   * <p>方法三：基于数组的循环队列 <br>
   * 除了 deque 之外，还可以应用另一种有趣的数据结构，称为循环队列 circular queue，它是一个环形的队列。 <br>
   * 通过向循环队列中添加新元素，它会自动丢弃最旧的元素。与 deque 不同，我们不需要显式地删除最旧的元素。 <br>
   * 循环队列的另一个优点是，一个指针就足以跟踪队列的两端，不像 deque 那样，我们必须为每一端保留一个指针。
   */
  ArrayList<Double> list = null;

  int size, head = 0, windowSum = 0, count = 0;
  int[] queue;
  /** Initialize your data structure here. */
  public MovingAverage346(int size) {
    this.size = size;
    queue = new int[size];
  }

  public double next(int val) {
    ++count;
    // 计算尾节点的位置
    int tail = (head + 1) % size;
    windowSum = windowSum - queue[tail] + val;
    // 移到下一个头节点
    head = (head + 1) % size;
    queue[head] = val;
    return windowSum * 1.0 / Math.min(size, count);
  }
}

/*
 * Your MovingAverage object will be instantiated and called as such: MovingAverage obj = new
 * MovingAverage(size); double param_1 = obj.next(val);
 */
