package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 *     <p>实现 NumArray 类：
 *     <p>NumArray(int[] nums) 使用数组 nums 初始化对象 int sumRange(int i, int j) 返回数组 nums
 *     从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * @author: Sxuet
 * @create: 2021-08-26 12:30
 */
public class NumArray303 {

  /**
   * 前缀和，由于会进行多次sumRange，为了降低检索时间O(1) 需要初始化预处理<br>
   * 执行用时： 7 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 43.04% 的用户
   */
  int[] sums;

  public NumArray303(int[] nums) {
    int length = nums.length;
    sums = new int[length + 1];
    for (int i = 0; i < nums.length; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    return sums[right + 1] - sums[left];
  }
}

/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
