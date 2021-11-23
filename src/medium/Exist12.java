package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个mxn二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false。
 *     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @since 2021-11-23 10:12
 */
public class Exist12 {
  /**
   * 执行用时： 5 ms , 在所有 Java 提交中击败了 61.43% 的用户 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 69.03% 的用户
   *
   * @param board
   * @param word
   * @return
   */
  public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, words, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean dfs(char[][] board, char[] word, int i, int j, int k) {
    // 终止条件 超出范围或者遍历到的值不符合返回false
    if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
      return false;
    }
    // 终止条件 遍历到最后返回true
    if (k == word.length - 1) {
      return true;
    }
    // 当前元素制空，不可重复访问
    board[i][j] = '\0';
    boolean res =
        dfs(board, word, i + 1, j, k + 1)
            || dfs(board, word, i - 1, j, k + 1)
            || dfs(board, word, i, j + 1, k + 1)
            || dfs(board, word, i, j - 1, k + 1);
    // 遍历完后，恢复值
    board[i][j] = word[k];
    return res;
  }
}
