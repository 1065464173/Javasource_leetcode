package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个已按照 升序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *     <p>函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1]
 *     <= numbers.length 。
 *     <p>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * @author: Sxuet
 * @create: 2021-07-21 22:35
 */
public class TwoSum167 {
  /**
   * 自创暴力解法
   *
   * <p>时间复杂度O(n^2) 空间1
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum1(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) {
          return new int[] {i + 1, j};
        }
      }
    }
    return null;
  }

  /**
   * 自创的双指针
   *
   * <p>时间复杂度O(n) n为numbers 的长度
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum2(int[] numbers, int target) {
    int pre = 0, post = numbers.length - 1;
    while (pre != post) {
      if (numbers[pre] + numbers[post] == target) {
        return new int[] {pre + 1, post + 1};
      }
      if ((numbers[pre] + numbers[post]) > target) {
        post--;
      } else {
        pre++;
      }
    }
    return null;
  }

  /**
   * 最好的方法 ！ 二分查找结合双指针
   *
   * <p>时间复杂度平均O(logn) 最坏O(n)
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum3(int[] numbers, int target) {
    int pre = 0, post = numbers.length - 1;
    while (pre < post) {
      int mid = pre + (post - pre) / 2;
      if (numbers[pre] + numbers[mid] > target) {
        post = mid - 1;
      } else if (numbers[mid] + numbers[post] < target) {
        pre = mid + 1;
      } else if (numbers[pre] + numbers[post] < target) {
        pre++;
      } else if (numbers[pre] + numbers[post] > target) {
        post--;
      } else {
        return new int[] {pre + 1, post + 1};
      }
    }
    return new int[] {-1, -1};
  }
}
