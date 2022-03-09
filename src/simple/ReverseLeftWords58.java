package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符
 *     串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @since 2021-11-12 10:33
 */
public class ReverseLeftWords58 {
  /**
   * 使用StringBuilder切片
   *
   * @param s
   * @param n
   * @return
   */
  public String reverseLeftWords1(String s, int n) {
    int length = s.length();
    StringBuilder sb = new StringBuilder(s).append(s);
    sb.delete(0, n).delete(length, 2 * length);
    return sb.toString();
  }

  public String reverseLeftWords2(String s, int n) {
    return (s + s).substring(n, s.length() + n);
  }

  /**
   * 直接使用substring切片
   *
   * @param s
   * @param n
   * @return
   */
  public String reverseLeftWords3(String s, int n) {
    return s.substring(n, s.length()) + s.substring(0, n);
  }

  /**
   * 字符串遍历拼接 - 使用求余操作简化 每次都要append 效率低下
   *
   * @param s
   * @param n
   * @return
   */
  public String reverseLeftWords4(String s, int n) {
    StringBuilder res = new StringBuilder();
    for (int i = n; i < n + s.length(); i++) {
      res.append(s.charAt(i % s.length()));
    }
    return res.toString();
  }
}
