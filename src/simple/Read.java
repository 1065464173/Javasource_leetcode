package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个文件，并且该文件只能通过给定的read4方法来读取，请实现一个方法使其能够读取 n 个字符。 read4 方法： APIread4可以从文件中读取 4
 *     个连续的字符，并且将它们写入缓存数组buf中。 返回值为实际读取的字符个数。 注意read4() 自身拥有文件指针，很类似于 C 语言中的 FILE *fp 。
 * @author: Sxuet
 * @create: 2021-07-20 16:54
 */
public class Read {
  /**
   * @param buf Destination buffer
   * @param n Number of characters to read
   * @return The number of actual characters read
   */
  // TODO:搬运的，没怎么看懂题目
  public int read(char[] buf, int n) {
    int i = 0, l = 1;
    while (i < n && l != 0) {
      char[] buf4 = new char[4];
      l = read4(buf4);
      for (int j = 0; j < l && i < n; j++) {
        buf[i++] = buf4[j];
      }
    }
    return i;
  }

  private int read4(char[] buf) {
    return 0;
  }
}
/*
read4 的定义：
参数类型: char[] buf4 返回类型: int
注意: buf4[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf4[] 当中。
下列是一些使用 read4 的例子：
File file("abcde"); // 文件名为 "abcde"， 初始文件指针 (fp) 指向 'a'
char[] buf4 = new char[4]; // 创建一个缓存区使其能容纳足够的字符
read4(buf4); // read4 返回 4。现在 buf4 = "abcd"，fp 指向 'e'
read4(buf4); // read4 返回 1。现在 buf4 = "e"，fp 指向文件末尾
read4(buf4); // read4 返回 0。现在 buf = ""，fp 指向文件末尾
 */
