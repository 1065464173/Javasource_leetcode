package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
 *     <p>给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将连续的两个"++"反转成"--"
 *     。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 *     <p>计算并返回 一次有效操作 后，字符串currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表[] 。
 * @author: Sxuet
 * @create: 2021-08-25 22:28
 */
public class GeneratePossibleNextMoves293 {
  /**
   * 自己写的解法
   *
   * <p>如果字符串长度小于2 直接返回集合<br>
   * 否则遍历字符串，依次变化两个++，并记录到list <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 51.65% 的用户
   *
   * @param currentState
   * @return
   */
  public List<String> generatePossibleNextMoves1(String currentState) {
    List<String> list = new ArrayList<>();
    if (currentState == null || currentState.length() < 2) {
      return list;
    }
    for (int i = 0; i < currentState.length() - 1; i++) {
      StringBuilder sb = new StringBuilder();
      if ('+' == currentState.charAt(i) && '+' == currentState.charAt(i + 1)) {
        sb.append(currentState.substring(0, i));
        sb.append("--");
        sb.append(currentState.substring(i + 2, currentState.length()));
        list.add(sb.toString());
      }
    }
    return list;
  }

  /**
   * 别人写的思路。和我的差不多，但是感觉实现地更好点<br>
   * 我用的StringBuilder，他是char[]数组，但是空间上占比差不多一样
   *
   * @param currentState
   * @return
   */
  public List<String> generatePossibleNextMoves2(String currentState) {
    List<String> result = new ArrayList<>();
    if (currentState == null || currentState.length() < 2) {
      return result;
    }
    char[] chars = currentState.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] == '+' && chars[i] == chars[i + 1]) {
        chars[i] = '-';
        chars[i + 1] = '-';
        result.add(new String(chars));
        chars[i] = '+';
        chars[i + 1] = '+';
      }
    }
    return result;
  }
}
