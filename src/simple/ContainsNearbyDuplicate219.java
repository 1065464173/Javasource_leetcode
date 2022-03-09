package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j k。
 * @author: Sxuet
 * @create: 2021-08-03 20:42
 */
public class ContainsNearbyDuplicate219 {
  /**
   * 自创暴力解法 时间复杂度O(n^2) 空间1<br>
   * 执行用时： 1598 ms , 在所有 Java 提交中击败了 11.86% 的用户<br>
   * 内存消耗： 50.3 MB , 在所有 Java 提交中击败了 24.41% 的用户
   *
   * @param nums
   * @param k
   * @return boolean
   */
  public boolean containsNearbyDuplicate1(int[] nums, int k) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j <= i + k && j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 自创的哈希表记录 时间复杂符O(n)只需遍历一次，空间复杂度O(n)，哈希表开销，最坏情况下没有重复元素
   *
   * <p>执行用时： 22 ms , 在所有 Java 提交中击败了 37.16% 的用户 <br>
   * 内存消耗： 47.4 MB , 在所有 Java 提交中击败了 34.53% 的用户
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    // 定义哈希表，key为num的值，value为num的索引集合
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 如果表里存在num 判断所存索引和当前索引相差是否小于k
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }
      // 添加或更新索引
      map.put(nums[i], i);
    }
    return false;
  }

  /**
   * 官方线性搜索 时间复杂度： O(nmin(k,n)) 每次搜索都要花费O(min(k,n)) 的时间，哪怕k比 n大，一次搜索中也只需比较 n 次。 空间复杂度： O(1)
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate3(int[] nums, int k) {
    for (int i = 0; i < nums.length; ++i) {
      for (int j = Math.max(i - k, 0); j < i; ++j) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 二叉搜索树 通过自平衡二叉搜索树来维护一个 k 大小的滑动窗口。 平衡二叉搜索树（BST)。 BST 中搜索，删除，插入都可以保持 O ( log ⁡ k ) O(logk) 的时间复杂度
   * 平衡二叉搜索树（BST)。 BST 中搜索，删除，插入都可以保持 O(logk) 的时间复杂度
   *
   * <p>时间复杂度：O(nlog(min(k,n))) 空间复杂度：O(min(n,k))滑动窗口的大小不会超过 O(min(n,k))。
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate4(int[] nums, int k) {
    // 定义树
    Set<Integer> set = new TreeSet<>();
    // 遍历数组
    for (int i = 0; i < nums.length; i++) {
      // 如果树中包含num，返回true
      if (set.contains(nums[i])) {
        return true;
      }
      // 否则添加值
      set.add(nums[i]);
      // 如果树的大小超过k，删除最旧值
      if (set.size() >= k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }

  /**
   * 用散列表来维护这个 k大小的滑动窗口，和上个实现方法一样，不过是数据结构的改变<br>
   * 时间复杂度O(n) 空间O(min(n,k))
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate5(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }
}
