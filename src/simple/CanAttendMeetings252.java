package simple;

import java.util.*;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi]
 *     ，请你判断一个人是否能够参加这里面的全部会议。
 * @author: Sxuet
 * @create: 2021-08-15 12:24
 */
public class CanAttendMeetings252 {
  /**
   * 自创的垃圾写法———好歹写出来了！
   *
   * <p>思路：遍历数组，每次存在把会议开始时间作为key，结束时间value存在map里 ，再把每个时间都存在ArrayList里，将list
   * 排序一下，若每个会议没有交集，那从头开始的两两一对都能在map里匹配对应的entry
   *
   * <p>执行用时： 9 ms , 在所有 Java 提交中击败了 15.33% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 7.60% 的用户
   *
   * @param intervals
   * @return
   */
  public boolean canAttendMeetings1(int[][] intervals) {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int[] interval : intervals) {
      map.put(interval[0], interval[1]);
      list.add(interval[0]);
      list.add(interval[1]);
    }
    Collections.sort(list);
    for (int i = 0; i < list.size(); i += 2) {
      if (!map.get(list.get(i)).equals(list.get(i + 1))) {
        return false;
      }
    }
    return true;
  }

  /**
   * 官方暴力解法，两两比较是否有交集
   *
   * <p>时间O(n^2) 空间O(1)<br>
   * 执行用时： 117 ms , 在所有 Java 提交中击败了 7.60% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 28.36% 的用户
   *
   * @param intervals
   * @return
   */
  public boolean canAttendMeetings2(int[][] intervals) {
    // 共有n个会议，每个会议都比较n-1次
    for (int i = 0; i < intervals.length; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        // 比较两个会议是否有交集
        if (overlap(intervals[i], intervals[j])) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean overlap(int[] i1, int[] i2) {
    return (Math.min(i1[1], i2[1]) > Math.max(i1[0], i2[0]));
  }

  /**
   * 官方排序 时间O(nlogn) 空间O(1)
   *
   * <p>按照开始时间对会议进行排序。接着依次遍历会议，检查它是否在下个会议开始前结束。 <br>
   * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.05% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 49.39% 的用户
   */
  public boolean canAttendMeetings3(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }
}
