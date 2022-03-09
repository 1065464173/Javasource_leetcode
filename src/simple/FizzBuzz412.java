package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 写一个程序，输出从 1 到 n 数字的字符串表示。
 *     <p>1. 如果n是3的倍数，输出“Fizz”；
 *     <p>2. 如果n是5的倍数，输出“Buzz”；
 *     <p>3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
 * @author: Sxuet
 * @create: 2021-09-14 20:23
 */
public class FizzBuzz412 {
  /**
   * 使用% 判断是否是某个数的倍数<br>
   * 时间复杂度：O（N），这里N是输入字符串的长度；空间复杂度：0（1），保存结果集的空间不计算在内。<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.39% 的用户 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 65.93% 的用户 <br>
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz1(int n) {
    List<String> ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i < 3) {
        ans.add(String.valueOf(i));
      } else if (i % 15 == 0) {
        ans.add("FizzBuzz");
      } else if (i % 3 == 0) {
        ans.add("Fizz");
      } else if (i % 5 == 0) {
        ans.add("Buzz");
      } else {
        ans.add(String.valueOf(i));
      }
    }
    return ans;
  }

  /**
   * 条件 1： 15 % 3 == 0, num_ans_str = "Fizz" 条件 2： 15 % 5 == 0, num_ans_str += "Buzz" => num_ans_str
   * = "FizzBuzz" .对于 FizzBuzz 来说，只需要判断两个条件就可以了，而不需要像方法一中那样判断三个条件。
   *
   * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 52.58% 的用户 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 38.66% 的用户 <br>
   * 时间复杂度：O（N）空间复杂度：0（1）
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz2(int n) {
    List<String> ans = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      boolean divisibleBy3 = (i % 3 == 0);
      boolean divisibleBy5 = (i % 5 == 0);
      if (divisibleBy3) {
        sb.append("Fizz");
      }
      if (divisibleBy5) {
        sb.append("Buzz");
      }
      if ("".equals(sb.toString())) {
        sb.append(i);
      }
      ans.add(sb.toString());
    }
    return ans;
  }

  /**
   * 方法二的改进，适用于条件多的情况 <br>
   * 执行用时： 6 ms , 在所有 Java 提交中击败了 25.82% 的用户 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 13.35% 的用户
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz3(int n) {
    List<String> ans = new ArrayList<>();
    HashMap<Integer, String> dict =
        new HashMap<Integer, String>() {
          {
            put(3, "Fizz");
            put(5, "Buzz");
          }
        };
    for (int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      for (Integer key : dict.keySet()) {
        if (i % key == 0) {
          sb.append(dict.get(key));
        }
      }
      if ("".equals(sb.toString())) {
        sb.append(i);
      }
      ans.add(sb.toString());
    }
    return ans;
  }
}
