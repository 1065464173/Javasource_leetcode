package cxymsjd6.medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * @since 2021-12-20 13:25
 */
public class SetZeroes0108 {
  /**
   * 使用格外空间记录当前位置是否为0<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.39% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 62.23% 的用户
   *
   * @param matrix
   */
  public void setZeroes1(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = col[j] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  /**
   * 使用原数组的第一行第一列记录是否有行和列的0 再使用额外空间记录第一行第一列的原数据<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.39% 的用户 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 78.29% 的用户
   *
   * @param matrix
   */
  public void setZeroes2(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean flagCol0 = false, flagRow0 = false;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        flagCol0 = true;
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        flagRow0 = true;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (flagCol0) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
    if (flagRow0) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
  }
}
