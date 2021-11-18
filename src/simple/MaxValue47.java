package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @since 2021-11-18 11:17
 */
public class MaxValue47 {
  /**
   * 动态规划<br>
   * 1. 划分问题:寻找最优礼物路径->每个格子记录上一步的最大值（Math.max(左边+自身，上+自身)）<br>
   * 2. 定义状态: 递推记录，每个格子记录从左上角出发到自身的最优解<br>
   * 3. 最优解: 每次递推时，记录最大的最优解 <br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 42.62% 的用户 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 19.81% 的用户
   *
   * @param grid
   * @return
   */
  public int maxValue1(int[][] grid) {
    int x = grid.length;
    int y = grid[0].length;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        // 第一行
        if (i == 0) {
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        }
        // 第一列
        else if (j == 0) {
          grid[i][j] = grid[i - 1][j] + grid[i][j];

        } else {
          grid[i][j] = Math.max(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]);
        }
      }
    }
    return grid[x - 1][y - 1];
  }

  /**
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 98.41% 的用户 内存消耗： 41 MB , 在所有 Java 提交中击败了 62.16% 的用户<br>
   * 精选答案 <br>
   * 思路和我一样，但是实现比我的更快。原因是他先初始化了第一列和第一行，使用了两次for循环+一次双重for循环（共三次）
   * 而我的是直接开始遍历，并且遍历每个元素的时候判断是否是第一列或者第一行。 <br>
   * by the way : 通过该答案发现 递推后最大和的路径总是会经过grid[m - 1][n - 1] 也就是最后值，所以过程中不需要再记录。直接递推到最后得出即可。
   *
   * @param grid
   * @return
   */
  public int maxValue2(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // 初始化第一行
    for (int j = 1; j < n; j++) {
      grid[0][j] += grid[0][j - 1];
    }
    // 初始化第一列
    for (int i = 1; i < m; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
      }
    }
    return grid[m - 1][n - 1];
  }
}
