package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description:给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *     <p>在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @author: Sxuet
 * @create: 2021-07-11 15:39
 */
public class YangHuiTriangle118 {
  /**
   * 时间复杂度：O(numRows^2 )。 空间复杂度：O(1)。
   *
   * @param numRows
   * @return
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
        }
      }
      triangle.add(row);
    }
    return triangle;
  }
}
