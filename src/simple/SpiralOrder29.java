package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @since 2021-12-04 13:56
 */
public class SpiralOrder29 {
  /**
   * * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.84% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 34.28% 的用户
   *
   * @param matrix
   * @return
   */
  public static int[] spiralOrder1(int[][] matrix) {

    if (matrix==null||matrix.length==0){
      return new int[0];
    }
    int c = matrix.length;
    int r = matrix[0].length;
    int[] ans = new int[r * c];
    int i = 0, j = 0, a = 0, t = 0;
    while (a < c * r) {
      while (i < r - t && a < c * r) {
        ans[a++] = matrix[j][i++];
      }
      i--;
      while (j < c - t - 1 && a < c * r) {
        ans[a++] = matrix[++j][i];
      }
      while (i > t && a < c * r) {
        ans[a++] = matrix[j][--i];
      }
      t++;
      while (j > t && a < c * r) {
        ans[a++] = matrix[--j][i];
      }
      i++;
    }
    return ans;
  }

  /**
   * 官方的模拟<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.84% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 52.64% 的用户
   *
   * @param matrix
   * @return
   */
  public int[] spiralOrder2(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    int rows = matrix.length, columns = matrix[0].length;
    int[] order = new int[rows * columns];
    int index = 0;
    int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
    while (left <= right && top <= bottom) {
      for (int column = left; column <= right; column++) {
        order[index++] = matrix[top][column];
      }
      for (int row = top + 1; row <= bottom; row++) {
        order[index++] = matrix[row][right];
      }
      if (left < right && top < bottom) {
        for (int column = right - 1; column > left; column--) {
          order[index++] = matrix[bottom][column];
        }
        for (int row = bottom; row > top; row--) {
          order[index++] = matrix[row][left];
        }
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return order;
  }
}
