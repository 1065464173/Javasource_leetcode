package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
 *     <p>实现 TwoSum 类：
 *     <p>TwoSum() 使用空数组初始化 TwoSum 对象 void add(int number) 向数据结构添加一个数 number boolean find(int value)
 *     寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
 * @author: Sxuet
 * @create: 2021-07-24 22:17
 */
public class TwoSumIII170 {
  /**
   * 时间复杂度： add(number): O(1) find(value)： O(N⋅log(N))，在最坏的情况下，我们需要对列表进行排序和遍历整个列表，这需要 O(N⋅log(N)) 和
   * O(N) 的时间。因此总的时间复杂度为 O(N⋅log(N))。 空间复杂度： O(N)，其中 N 指的是列表中的元素个数。
   */
  /** 使用哈希表可以将find的时间复杂度降为O(n),这里不再放出代码 */
  List<Integer> list;

  private boolean is_sorted;
  /** Initialize your data structure here. */
  public TwoSumIII170() {
    list = new ArrayList<>();
    is_sorted = false;
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    list.add(number);
    is_sorted = false;
  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   *
   * <p>双指针结合二分
   */
  public boolean find(int value) {
    if (!is_sorted) {
      Collections.sort(list);
      is_sorted = true;
    }
    int p1 = 0, p2 = list.size() - 1;
    while (p1 < p2) {
      int mid = p1 + (p2 - p1) / 2;
      if (list.get(p1) + list.get(mid) > value) {
        p2 = mid - 1;
      } else if (list.get(p2) + list.get(mid) < value) {
        p1 = mid + 1;
      } else if (list.get(p1) + list.get(p2) > value) {
        p2--;
      } else if (list.get(p1) + list.get(p2) < value) {
        p1++;
      } else {
        return true;
      }
    }
    return false;
  }
}

/*
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
