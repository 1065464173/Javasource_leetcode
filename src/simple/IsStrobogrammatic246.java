package simple;

import java.util.HashMap;

/**
 * @program: Javasource_leetcode
 * @description: 中心对称数是指一个数字在旋转了180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *     <p>请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * @author: Sxuet
 * @create: 2021-08-13 10:20
 */
public class IsStrobogrammatic246 {
  /**
   * 能对称的数有:6,9,8,1,0 哈希表和左右双指针遍历即可 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 66.06% 的用户
   *
   * @param num
   * @return
   */
  public boolean isStrobogrammatic1(String num) {
    HashMap<Character, Character> map = new HashMap<>();
    map.put('6', '9');
    map.put('9', '6');
    map.put('1', '1');
    map.put('0', '0');
    map.put('8', '8');
    int left = 0, right = num.length() - 1;
    while (left <= right) {
      Character c1 = map.get(num.charAt(left));
      Character c2 = map.get(num.charAt(right));
      if (c1 == null || c2 == null) {
        return false;
      } else if (c1 != num.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
