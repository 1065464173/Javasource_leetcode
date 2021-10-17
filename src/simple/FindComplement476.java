package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-10-15 09:54
 */
public class FindComplement476 {
  public int findComplement1(int num) {
    int mask = -1; // 0xFFFFFFFF 即全为1 补码存的！
    while ((mask & num) > 0) {
      mask <<= 1;
    }
    return ~mask ^ num;
  }

  public int findComplement2(int num) {
    int ans = 1, pos = 1;
    while (ans < num) {
      ans |= (1 << pos);
      pos++;
    }
    ans ^= num;
    return ans;
  }
}
