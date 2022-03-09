package difficult;

/**
 * @author Sxuet
 * @program daydayup
 * @description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @since 2021-12-09 16:38
 */
public class ReversePairs51 {

  /**
   * 暴力解法<br>
   * 超出时间限制
   *
   * @param nums
   * @return
   */
  public int reversePairs1(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          ans++;
        }
      }
    }
    return ans;
  }

  int[] nums, tmp;

  /**
   * 分治排序<br>
   * 执行用时： 38 ms , 在所有 Java 提交中击败了 16.52% 的用户 内存消耗： 47.5 MB , 在所有 Java 提交中击败了 43.97% 的用户
   *
   * @param nums
   * @return
   */
  public int reversePairs(int[] nums) {
    this.nums = nums;
    tmp = new int[nums.length];
    return mergeSort(0, nums.length - 1);
  }

  private int mergeSort(int l, int r) {
    // 终止条件
    if (l >= r) return 0;
    // 递归划分
    int m = (l + r) / 2;
    int res = mergeSort(l, m) + mergeSort(m + 1, r);
    // 分成两份后分别的结果相加
    int i = l, j = m + 1;
    // 将[l,r]用一个数组保存合并之前的模样
    for (int k = l; k <= r; k++) {
      tmp[k] = nums[k];
    }
    // 对[l,r]中的[l,m]、[m+1,r]开始合并
    for (int k = l; k <= r; k++) {
      // m及其左边元素合并完毕,把右边剩下的放入合并后的数组
      if (i == m + 1) {
        nums[k] = tmp[j++];
      }
      // m+1及其右边元素合并完毕,把左边剩下的放入合并后的数组 或者 左边数组的元素小于等于右边,将左边数组的元素放入结果数组中,并让索引i加1
      else if (j == r + 1 || tmp[i] <= tmp[j]) {
        nums[k] = tmp[i++];
      }
      // 右边数组的元素小于左边,将右边数组的元素其放入结果数组中,并让索引j加1
      // 并且此时左边数组中的从i到m的所有数都是大于tmp[j]的(因为m左右的数组都是已经排好序的，第15行代码的功劳)
      // 即此时有m-i+1个逆序对，加到res上即可
      // 即if(tmp[i]>tmp[j])这种情况
      else {
        nums[k] = tmp[j++];
        // 统计逆序对
        res += m - i + 1;
      }
    }
    return res;
  }
}
