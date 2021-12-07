package medium;

import liquibase.pro.packaged.S;

import java.util.*;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个字符串，打印出该字符串中字符的所有排列。 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @since 2021-12-07 13:28
 */
public class Permutation38 {
  HashSet<String> res = new HashSet<>();

  /**
   * 考虑三个问题： <br>
   * 1. 路径：也就是已经做出的选择。 <br>
   * 2. 选择列表：也就是你当前可以做的选择。 <br>
   * 3. 结束条件：也就是到达决策树底层，无法再做选择的条件。 <br>
   * 执行用时： 38 ms , 在所有 Java 提交中击败了 23.58% 的用户 内存消耗： 42.8 MB , 在所有 Java 提交中击败了 60.84% 的用户
   *
   * @param s
   * @return
   */
  public String[] permutation(String s) {
    // 记录「路径」
    StringBuilder track = new StringBuilder();
    char[] chars = s.toCharArray();
    // 「选择列表」 chars
    // backtrack(选择列表, 路径);
    backtrack(chars, track);
    return res.toArray(new String[0]);
  }

  private void backtrack(char[] chars, StringBuilder track) {
    // 「结束条件」到达决策树的底层 —— 路径长度等于选择列表长度
    if (track.length() == chars.length) {
      res.add(track.toString());
      return;
    }

    for (int i = 0; i < chars.length; i++) {
      // 排除不合理选择
      if (chars[i]==0) {
        continue;
      }
      // 做选择
      track.append(chars[i]);
      char temp = chars[i];
      chars[i]=0;
      // 进入下一层决策树
      backtrack(chars, track);
      // 取消选择
      track.deleteCharAt(track.length()-1);
      chars[i]=temp;
    }
  }
}
