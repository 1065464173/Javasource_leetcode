package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 要求时间复杂度为O（n）。
 * @since 2021-11-18 10:30
 */
public class MaxSubArray42 {
  /**
   * 动态规划:<br>
   * 1. 拆分问题：子数组和最大->每个数判断自己和前一个数相加是否大于自身<br>
   * 2. 定义问题与状态关系: 大于自身-元素值转为和，小于自身-重新计算和。 <br>
   * 3. 只保存最优解：递推过程中记录和最大值（最大元素值） <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.66% 的用户 内存消耗： 44.8 MB , 在所有 Java 提交中击败了 65.69% 的用户
   *
   * @param nums
   * @return
   */
  public int maxSubArray1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSubSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] = Math.max(nums[i] - nums[i - 1], nums[i]);
      maxSubSum = Math.max(nums[i], maxSubSum);
    }
    return maxSubSum;
  }

  // ==============================================================

  /**
   * 分治：线段树<br>
   * 「方法二」相较于「方法一」来说，时间复杂度相同，但是因为使用了递归，并且维护了四个信息的结构体，运行的时间略长，空间复杂度也不如方法一优秀，而且难以理解。那么这种方法存在的意义是什么呢？
   * 对于这道题而言，确实是如此的。但是仔细观察「方法二」，它不仅可以解决区间【0，n-1】，还可以用于解决任意的子区间【，r】的问题。如果我们把【0，n-1】分治下去出现的所有子区间的信息都用堆式存储的方式记忆化下来，即建成一颗真正的树之后，我们就可以在O（logn）的时间内求到任意区间内的答案，我们甚至可以修改序列中的值，做一些简单的维护，之后仍然可以在O（logn）的时间内求到任意区间内的答案，对于大规模查询的情况下，这种方法的优势便体现了出来。这棵树就是上文提及的一种神奇的数据结构一线段树。
   */
  class Status {
    /**
     * lSum表示【l，r】内以l为左端点的最大子段和 = Math.max(lSum,iSum+rSum)<br>
     * rSum表示【l，r】内以r为右端点的最大子段和= Math.max(rSum,iSum+lSum)<br>
     * mSum表示【l，r】内的最大子段和 = Math.max(左区间mSum,右区间mSum,lSum+rSum<br>
     * iSum表示【l，r】的区间和 = 左区间iSum+右区间iSum
     */
    public int lSum, rSum, mSum, iSum;

    public Status(int lSum, int rSum, int mSum, int iSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.mSum = mSum;
      this.iSum = iSum;
    }
  }
  /**
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {

    return getInfo(nums, 0, nums.length - 1).mSum;
  }

  private Status getInfo(int[] nums, int l, int r) {
    if (l == r) {
      return new Status(nums[l], nums[l], nums[l], nums[l]);
    }
    int m = l + (r - l) / 2;
    Status lSub = getInfo(nums, l, m);
    Status rSub = getInfo(nums, m + 1, r);
    return pushUp(lSub, rSub);
  }

  private Status pushUp(Status l, Status r) {
    int iSum = l.iSum + r.iSum;
    int lSum = Math.max(r.lSum + l.iSum, l.lSum);
    int rSum = Math.max(r.rSum, r.iSum + l.rSum);
    int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    return new Status(lSum, rSum, mSum, iSum);
  }
}
