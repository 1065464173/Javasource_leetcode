package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     在一个n*m的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @since 2021-11-14 14:38
 */
public class FindNumberIn2DArray04 {
  /**
   * 线性增<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 44.2 MB , 在所有 Java 提交中击败了 31.45% 的用户
   *
   * @param matrix
   * @param target
   * @return
   */
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int rows = matrix.length, columns = matrix[0].length;
    int row = 0, column = columns - 1;
    while (row < rows && column >= 0) {
      int num = matrix[row][column];
      if (num == target) {
        return true;
      } else if (num > target) {
        column--;
      } else {
        row++;
      }
    }
    return false;
  }
}
