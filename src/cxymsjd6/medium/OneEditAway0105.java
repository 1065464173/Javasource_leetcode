package cxymsjd6.medium;


/**
 * @author Sxuet
 * @program daydayup
 * @description 字符串有三种编辑操作：插入一个字符、删除一个字符或者替换一个字符。给定两个字符串，编写一个函数判定它们是否只需要一次（或者零次）编辑。
 * @since 2021-12-03 16:52
 */
public class OneEditAway0105 {
  /**
   * 查看是连个字符串是否只有一个字符之差即可<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 54.42% 的用户
   *
   * @param first
   * @param second
   * @return
   */
  public boolean oneEditAway(String first, String second) {
    int fLen = first.length(), sLen = second.length(), dLen = fLen - sLen;
    // 如果两个字符串长度相差超过1个，则必然不能一次编辑
    if (Math.abs(dLen) > 1) {
      return false;
    }
    // 双指针 f为first的遍历指针，s为second遍历指针
    // t为编辑次数
    int t = 0, f = 0, s = 0;
    while (f < fLen && s < sLen) {
      // 如果遇到值不相等时，编辑次数+1
      if (first.charAt(f) != second.charAt(s)) {
        t++;
        // dLen为字符串1和字符串2的长度差
        // 修改：dLen==0,继续进行下一个字符的遍历
        // f增加：dLen>0, f的下个字符与s的当前字符继续进行比较
        // f删除：dLen<0, s的下一个字符与f当前字符进行比较
        f += (dLen >= 0) ? 1 : 0;
        s += (dLen <= 0) ? 1 : 0;
      } else {
        f++;
        s++;
      }
    }
    return t < 2;
  }
}
