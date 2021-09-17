package simple;

import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个单词序列，判断其是否形成了一个有效的单词方块。
 *     <p>有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
 *     <p>注意：
 *     <p>给定的单词数大于等于 1 且不超过 500。 单词长度大于等于 1 且不超过 500。 每个单词只包含小写英文字母 a-z。
 * @author: Sxuet
 * @create: 2021-09-17 11:01
 */
public class ValidWordSquare422 {
  /**
   * 对角线判断<br>
   * words[x][y] = words[y][x]时就为有效单词方块<br>
   * words[x][y] = words.get(x).charAt(y) <br>
   * 得注意边缘数据越界 <br>
   * 执行用时：14ms，在所有Java提交中击败了55.07%的用户 内存消耗：38.2MB，在所有Java提交中击败了62.32%的用户
   *
   * @param words
   * @return
   */
  public boolean validWordSquare(List<String> words) {
    int size = words.size();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        // 防止出现某一列的单词长度超出整个正方形的边长（也就是行的长度）
        // 如果这一行单词长度（也就是列长）没有对应那一列的行的长度长，肯定不对称
        if (j >= size
            || i >= words.get(j).length()
            || words.get(i).charAt(j) != words.get(j).charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }
}
