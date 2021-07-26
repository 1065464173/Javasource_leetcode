package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: Sxuet
 * @create: 2021-06-17 14:48
 */
public class MaxSubArray53 {
  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6
    System.out.println(maxSubArray03(nums));
  }

  /**
   * @description: 贪心算法，时间复杂度O(n)，空间复杂度O(1)
   * @param: int[]
   * @return: int
   * @author: Sxuet
   * @date: 2021/6/18 12:40 下午
   */
  public static int maxSubArray03(int[] nums) {
    int sum = 0;
    int maxAns = 0;
    for (int num : nums) {
      sum += num;
      maxAns = Math.max(sum, maxAns);
      if (sum < 0) {
        sum = 0;
      }
    }
    return maxAns;
  }

  /**
   * @description: 动态规划 时间复杂度O(n) 空间复杂度O(1) 求数组每个位置的f(i)值 f(i) 代表以第i个数结尾的「连续子数组的最大和」
   *     f(i)=max{f(i−1)+nums[i],nums[i]}
   * @param: nums
   * @return: int
   * @author: Sxuet
   * @date: 2021/6/17 3:04 下午
   */
  public static int maxSubArray01(int[] nums) {
    int maxAns = nums[0], pre = 0;
    for (int num : nums) {
      pre = Math.max(pre + num, num);
      maxAns = Math.max(maxAns, pre);
    }
    return maxAns;
  }

  /**
   * 查询a序列[l,r]区间内的最大子段和
   *
   * @param a
   * @param l
   * @param r
   * @return Status
   */
  public static Status getInfo(int[] a, int l, int r) {
    if (l == r) {
      return new Status(a[l], a[l], a[l], a[l]);
    }
    int m = (l + r) >> 1;
    Status lSub = getInfo(a, l, m);
    Status rSub = getInfo(a, m + 1, r);
    return pushUp(lSub, rSub);
  }

  public static Status pushUp(Status l, Status r) {
    int iSum = l.iSum + r.iSum;
    int lSum = Math.max(l.lSum, l.iSum + r.lSum);
    int rSum = Math.max(r.rSum, r.iSum + l.rSum);
    int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    return new Status(lSum, rSum, iSum, mSum);
  }

  public static int maxSubArray02(int[] nums) {
    return getInfo(nums, 0, nums.length - 1).mSum;
  }

  /**
   * @description: 分治 时间复杂度为O(n) 空间复杂度为O(logn) 类似于「线段树求解最长公共上升子序列问题」的 pushUp 操作
   *     推荐阅读线段树区间合并法解决多次询问的「区间最长连续上升序列问题」和「区间最大子段和问题」
   * @param: int[] nums
   * @return: int maxAns
   * @author: Sxuet
   * @date: 2021/6/17 3:55 下午
   */
  static class Status {
    /** lSum表示[l,r]以l为左端点的最大子段和 rSum表示[l,r]以r为右端点的最大子段和 iSum表示[l,r] 的区间和 mSum表示[l,r]区间内的最大子段和 */
    int lSum, rSum, iSum, mSum;

    public Status(int lSum, int rSum, int iSum, int mSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.iSum = iSum;
      this.mSum = mSum;
    }
  }
}
