package simple;

import java.util.HashSet;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-08-30 21:01
 */
public class ReverseVowels345 {
  /**
   * 自己写的hashset双指针交换。无脑<br>
   * 执行用时： 4 ms , 在所有 Java 提交中击败了 48.52% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 49.10% 的用户
   *
   * @param s
   * @return
   */
  public String reverseVowels1(String s) {
    HashSet<Character> hashSet = new HashSet<>(5);
    hashSet.add('a');
    hashSet.add('e');
    hashSet.add('i');
    hashSet.add('o');
    hashSet.add('u');
    hashSet.add('A');
    hashSet.add('E');
    hashSet.add('I');
    hashSet.add('O');
    hashSet.add('U');
    char[] chars = s.toCharArray();
    int j = chars.length - 1;
    int i = 0;
    while (i < j) {
      while (i < j && !hashSet.contains(chars[i])) {
        i++;
      }
      while (i < j && !hashSet.contains(chars[j])) {
        j--;
      }
      char temp = chars[i];
      chars[i++] = chars[j];
      chars[j--] = temp;
    }
    return new String(chars);
  }

  /**
   * 官方的双指针交换 性能比我好一倍？<br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 81.81% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 81.34% 的用户
   *
   * @param s
   * @return
   */
  public String reverseVowels2(String s) {
    int n = s.length();
    char[] arr = s.toCharArray();
    int i = 0, j = n - 1;
    while (i < j) {
      while (i < n && !isVowel(arr[i])) {
        ++i;
      }
      while (j > 0 && !isVowel(arr[j])) {
        --j;
      }
      if (i < j) {
        swap(arr, i, j);
        ++i;
        --j;
      }
    }
    return new String(arr);
  }

  public boolean isVowel(char ch) {
    return "aeiouAEIOU".indexOf(ch) >= 0;
  }

  public void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
