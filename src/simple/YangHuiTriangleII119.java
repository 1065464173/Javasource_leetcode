package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *     <p>输入: 3 输出: [1,3,3,1]
 * @author: Sxuet
 * @create: 2021-07-11 16:40
 */
public class YangHuiTriangleII119 {
  /**
   * 时间复杂度O(rowIndex^2)。 空间复杂度 O(1)。不考虑返回值的空间占用。
   *
   * @param rowIndex
   * @return
   */
  public List<Integer> getRow1(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    row.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      row.add(0);
      for (int j = i; j > 0; --j) {
        row.set(j, row.get(j) + row.get(j - 1));
      }
    }
    return row;
  }

  /**
   * 线性递推
   *
   * <p>由杨辉三角的性质得组合数C(m,n)=n!/(m!(n-m)!)
   *
   * <p>所以C(m,n) = c(m-1,n) +(n-m+1)/m
   *
   * <p>时间复杂度：O(rowIndex)。 空间复杂度：O(1)。不考虑返回值的空间占用
   *
   * @param rowIndex
   * @return
   */
  public List<Integer> getRow2(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    row.add(1);
    for (int i = 1; i < rowIndex; i++) {
      row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
    }
    return row;
  }
}
