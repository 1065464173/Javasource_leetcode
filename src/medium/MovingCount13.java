package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     地上有一个m行n列的方格，从坐标【0，0】到坐标【m-1，n-1】。一个机器人从坐标【0，0】的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格【35，37】，因为3+5+3+7-18。但它不能进入方格【35，38】，因为3+5+3+8-19。请问该机器人能够到达多少个格子？
 * @since 2021-11-23 11:04
 */
public class MovingCount13 {
  int ach = 0;

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 52.08% 的用户
   *
   * @param m
   * @param n
   * @param k
   * @return
   */
  public int movingCount(int m, int n, int k) {
    int[][] scope = new int[m][n];
    // 在n*m的方格内从[0,0]进行遍历，遍历位数之和小于k的格子的数量
    dfs(scope, 0, 0, k);
    return ach;
  }

  private void dfs(int[][] scope, int m, int n, int k) {
    // 终止条件 m n 超出数组范围或者位数只和大于给定的k
    if (m < 0
        || m >= scope.length
        || n < 0
        || n >= scope[0].length
        || (m / 10 + m % 10 + n / 10 + n % 10) > k) {
      return;
    }
    // 终止条件 该方格已经遍历过
    if (scope[m][n] == 1) {
      return;
    }
    ach++;
    // 遍历过则将方格置1
    scope[m][n] = 1;
    dfs(scope, m, n + 1, k);
    dfs(scope, m + 1, n, k);
    // 隐藏优化：不用向上和向左深度遍历
    // dfs(scope, m - 1, n, k);
    // dfs(scope, m, n - 1, k);
  }
}
