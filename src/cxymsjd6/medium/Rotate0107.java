package cxymsjd6.medium;

public class Rotate0107 {
  /**
   * 原地旋转使用临时变量暂存被替换的数，<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 61.09% 的用户
   *
   * @param matrix
   */
  public void rotate1(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; ++i) {
      for (int j = 0; j < (n + 1) / 2; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
    }
  }

  /**
   * 取巧，使用翻转代替旋转<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 38.65% 的用户
   *
   * @param matrix
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    // 水平翻转
    for (int i = 0; i < n / 2; ++i) {
      for (int j = 0; j < n; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - i - 1][j];
        matrix[n - i - 1][j] = temp;
      }
    }
    // 主对角线翻转
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
