package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *     <p>注意:
 *     <p>十六进制中所有字母(a-f)都必须是小写。
 *     十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。  给定的数确保在32位有符号整数范围内。
 *     不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * @author: Sxuet
 * @create: 2021-09-12 21:15
 */
public class ToHex405 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 66.22% 的用户
   *
   * @param num
   * @return
   */
  public String toHex1(int num) {
    return Integer.toHexString(num);
  }

  /**
   * 10进制转2进制转16进制的过程 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 38.54% 的用户
   *
   * @param num
   * @return
   */
  public String toHex2(int num) {
    // 0特殊处理
    if (num == 0) {
      return "0";
    }
    // 10进制转换2进制
    int[] bits = new int[32];
    for (int i = 31; i >= 0; i--) {
      bits[i] = num & 1;
      num >>>= 1;
    }
    // 2进制转换16进制
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i <= 28; i += 4) {
      int sum = 8 * bits[i] + 4 * bits[i + 1] + 2 * bits[i + 2] + bits[i + 3];
      if (sum <= 9) {
        ans.append((char) (sum + '0'));
      } else if (sum <= 15) {
        ans.append((char) (sum - 10 + 'a'));
      }
    }
    // 去掉前导0，这就是为什么0要特殊处理的原因
    // 因为0的十六进制还是全为0，用这个循环会越界访问
    while (ans.charAt(0) == '0') {
      ans.deleteCharAt(0);
    }
    return ans.toString();
  }

  /**
   * @param num
   * @return
   */
  public String toHex3(int num) {
    // 0特殊处理
    if (num == 0) {
      return "0";
    }
    // 相当于映射关系
    char[] hex = "0123456789abcdef".toCharArray();
    StringBuilder ans = new StringBuilder();
    // while的循环条件保证了不会出现前导0
    while (num != 0) {
      // 取低4位的十进制值
      int temp = num & 0xf;
      // 映射对应字符
      ans.append(hex[temp]);
      // 逻辑右移4位
      num >>>= 4;
    }
    // 但是从低位开始转换多了一步reverse反转
    return ans.reverse().toString();
  }
}
