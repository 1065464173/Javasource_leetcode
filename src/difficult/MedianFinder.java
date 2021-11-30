package difficult;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Sxuet
 * @program daydayup
 * @description MedianFinder
 * @since 2021-11-26 10:54
 */
public class MedianFinder {
  /** 执行用时： 65 ms , 在所有 Java 提交中击败了 89.10% 的用户 内存消耗： 49.7 MB , 在所有 Java 提交中击败了 21.33% 的用户 */
  Queue<Integer> A, B;
  /** initialize your data structure here. */
  public MedianFinder() {
    // 小顶堆，保存较大的一半
    A = new PriorityQueue<>();
    // 大顶堆，保存较小的一半
    B = new PriorityQueue<>((x, y) -> (y - x));
  }

  public void addNum(int num) {
    if (A.size() != B.size()) {
      A.add(num);
      B.add(A.poll());
    } else {
      B.add(num);
      A.add(B.poll());
    }
  }

  public double findMedian() {
    return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
  }
}
/*
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
