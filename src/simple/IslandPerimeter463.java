package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-10-15 09:36
 */
public class IslandPerimeter463 {
  /**
   * 暴力解法 <br>
   * 执行用时： 7 ms , 在所有 Java 提交中击败了 90.74% 的用户 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 68.62% 的用户
   *
   * @param grid
   * @return
   */
  public int islandPerimeter(int[][] grid) {
    int perimeter = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          perimeter += 4;
          if (i != 0 && grid[i - 1][j] == 1) {
            perimeter--;
          }
          if (j != 0 && grid[i][j - 1] == 1) {
            perimeter--;
          }
          if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
            perimeter--;
          }
          if (i != grid.length - 1 && grid[i + 1][j] == 1) {
            perimeter--;
          }
        }
      }
    }
    return perimeter;
  }
}
