package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 在MATLAB中，有一个非常有用的函数 reshape,它可以将一个mxn矩阵重塑为另一个大小不同（rxc）的新矩阵，但保留其原始数据。
 *     给你一个由二维数组mat表示的mxn矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *     如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * @since 2021-11-21 19:41
 */
public class MatrixReshape566 {
  /**
   * @param mat
   * @param r
   * @param c
   * @return
   */
  public int[][] matrixReshape1(int[][] mat, int r, int c) {
    int x0 = mat.length;
    int y0 = mat[0].length;
    if (r * c != x0 * y0) {
      return mat;
    }
    int[][] ans = new int[r][c];
    int x = 0, y = 0, i = 0, j = 0;
    while (x != r) {
      if (i < x0 && j < y0 && x < r && y < c) {
        ans[x][y++] = mat[i][j++];
        continue;
      }
      if (j >= y0) {
        j = 0;
        i++;
      }
      if (y >= c) {
        y = 0;
        x++;
      }
    }
    return ans;
  }

  /**
   * 官方二维数组的一维表示， 和我自己上一个实现的方法一样，但是实现的更简洁 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 92.71% 的用户
   *
   * @param nums
   * @param r
   * @param c
   * @return
   */
  public int[][] matrixReshape2(int[][] nums, int r, int c) {
    int m = nums.length;
    int n = nums[0].length;
    if (m * n != r * c) {
      return nums;
    }

    int[][] ans = new int[r][c];
    /*
     * 这一块的实现很巧妙
     */
    for (int x = 0; x < m * n; ++x) {
      ans[x / c][x % c] = nums[x / n][x % n];
    }
    return ans;
  }
}
