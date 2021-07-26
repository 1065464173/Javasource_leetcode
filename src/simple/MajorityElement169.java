package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊n/2⌋的元素。
 *     <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author: Sxuet
 * @create: 2021-07-23 21:47
 */
public class MajorityElement169 {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 4, 2, 36, 8, 4, 69};
    quickSort(nums, 0, nums.length - 1);
    for (int num : nums) {
      System.out.println(num);
    }
  }

  /**
   * 快速排序 时间复杂度为O(nlogn) 空间复杂度O(1) 原地排，不稳定
   *
   * @param nums
   * @param low
   * @param high
   */
  public static void quickSort(int[] nums, int low, int high) {

    // 快速排序
    if (low > high) {
      return;
    }
    int p1 = low, p2 = high, pivot = nums[low], temp;
    while (p1 < p2) {
      /*
       * 假如最好的情况是一个有序序列 1 3 5 7 9
       * temp = 1
       * i = 0    arr[i] = 1
       * j = 4    arr[j] = 9
       * 而且在这里，如果先从左边开始寻找的话，一直往右寻找大于1的数，直到i变成4还没有找到就停止了；但是下面的语句就会把9赋值在1上了
       * 如果先从右边开始寻找的话，一直往左寻找小于1的数，直到j变成0还没有找到然后停止，此时i和j都是0，所以就是把自身交换一下并不影响顺序。
       * 这也是为什么强调如果选择数组左边第一个数作为基准值的时候，得先从右边开始查找数。
       */
      // 先看右边，依次向左递减
      while (pivot <= nums[p2] && p1 < p2) {
        p2--;
      }
      // 再看左边，依次向右边递减
      while (pivot >= nums[p1] && p1 < p2) {
        p1++;
      }
      // 满足条件交换
      if (p1 < p2) {
        temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
      }
    }
    // 与基准数互换位子
    nums[low] = nums[p1];
    nums[p1] = pivot;
    // 递归调用左半部分
    quickSort(nums, low, p2 - 1);
    // 递归调用右半部分
    quickSort(nums, p2 + 1, high);
  }

  /**
   * 自创暴力解法
   *
   * <p>时间复杂度O(n) 空间复杂符O(n)
   *
   * @param nums
   * @return
   */
  public int majorityElement1(int[] nums) {
    if (nums.length < 2) {
      return nums[0];
    }
    int mid = nums.length / 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int value = 0;
      if (map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        value = map.get(nums[i]);
        map.put(nums[i], ++value);
      }
      if (value >= mid) {
        return nums[i];
      }
    }
    return 0;
  }

  /**
   * 先使用快速排序 其排序的时间复杂度为O(nlogn) 空间复杂度O(1) 原地排，不稳定
   *
   * <p>如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为⌊n/2⌋的元素（下标从 0 开始）一定是众数
   *
   * <p>神奇！！！为什么可以查看leetcode官方解说
   *
   * @param nums
   * @return
   */
  public int majorityElement2(int[] nums) {
    // TODO：神奇没有想到的决策
    // 官方的排序 时间复杂度O(nlogn) 时间复杂度O(logn)
    //    Arrays.sort(nums);
    quickSort(nums, 0, nums.length - 1);
    return nums[nums.length / 2];
    // 以下是自己写的傻瓜方法
    /*
    int mid = nums.length / 2, count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        count++;
      } else {
        count = 0;
      }
      if (count > mid) {
        return nums[i];
      }
    }
    return -1;
    */
  }

  /**
   * 神奇！！随机赌徒心态
   *
   * <p>理论上最坏情况下的时间复杂度为O(∞)，因为如果我们的运气很差，这个算法会一直找不到众数，
   *
   * <p>随机挑选无穷多次，所以最坏时间复杂度是没有上限的。然而，运行的期望时间是线性的。
   *
   * <p>为了更简单地分析，先说服你自己：由于众数占据 超过 数组一半的位置，期望的随机次数会小于众数占据数组恰好一半的情况。因此，我们可以计算随机的期望次数
   * 当众数恰好占据数组的一半时，第一次随机我们有 1/2 的概率找到众数，如果没有找到，则第二次随机时，包含上一次我们有 1/4
   * 的概率找到众数，以此类推。可以计算出这个期望值和为2，说明期望的随机次数是常数。
   *
   * <p>每一次随机后，我们需要 O(n) 的时间判断这个数是否为众数，因此期望的时间复杂度为 O(n)。 空间复杂度 O(1)。随机方法只需要常数级别的额外空间。
   *
   * @param nums
   * @return
   */
  public int majorityElement3(int[] nums) {
    Random rand = new Random();

    int majorityCount = nums.length / 2;

    while (true) {
      int candidate = nums[randRange(rand, 0, nums.length)];
      if (countOccurences(nums, candidate) > majorityCount) {
        return candidate;
      }
    }
  }

  /**
   * 生成指定范围内的随机数
   *
   * @param rand
   * @param min
   * @param max
   * @return 随机数
   */
  private int randRange(Random rand, int min, int max) {
    return rand.nextInt(max - min) + min;
  }

  /**
   * 验证随机数出现的次数
   *
   * @param nums
   * @param num
   * @return 返回该数出现的次数
   */
  private int countOccurences(int[] nums, int num) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }

  /**
   * 我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。
   *
   * <p>时间复杂度为O(nlogn) 空间复杂度O(nlogn)
   *
   * <p>长度为 1 的子数组中唯一的数显然是众数，直接返回即可。如果回溯后某区间的长度大于1，我们必须将左右子区间的值合并。
   *
   * <p>如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
   *
   * @param nums
   * @return
   */
  public int majorityElement4(int[] nums) {
    // TODO:好好看看这个！没怎么看代码，思路很好
    return majorityElementRec(nums, 0, nums.length - 1);
  }

  private int majorityElementRec(int[] nums, int lo, int hi) {
    // base case; the only element in an array of size 1 is the majority
    // element.
    if (lo == hi) {
      return nums[lo];
    }

    // recurse on left and right halves of this slice.
    int mid = (hi - lo) / 2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid + 1, hi);

    // if the two halves agree on the majority element, return it.
    if (left == right) {
      return left;
    }

    // otherwise, count each element and return the "winner".
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
  }

  private int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }

  /**
   * Boyer-Moore 投票算法
   *
   * <p>时间复杂度为O(n) 空间复杂度O(1)
   *
   * <p>如果我们把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多
   *
   * <p>Boyer-Moore 算法的本质和方法四中的分治十分类似 具体请看官方的解说（很复杂）。还是别人的解说好懂
   *
   * @param nums
   * @return
   */
  public int majorityElement5(int[] nums) {
    // TODO: 这个方法很高级！但是看不懂，原理有点难懂
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
}
