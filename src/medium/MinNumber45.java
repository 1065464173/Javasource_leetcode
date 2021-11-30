package medium;

import java.util.Arrays;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @since 2021-11-25 08:45
 */
public class MinNumber45 {

  public String minNumber(int[] nums) {
    String[] copyNums = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      copyNums[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(copyNums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
    StringBuilder res = new StringBuilder();
    for (String s : copyNums) {
      res.append(s);
    }
    return res.toString();
  }
}
