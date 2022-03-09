package simple;

/**
 * @program: Javasource_leetcode
 * @description: 作为一位web开发者，懂得怎样去规划一个页面的尺寸是很重要的。现给定一个具体的矩形页面面积，你的任务是设计一个长度为L和宽度为W且满足以下要求的矩形的页面。要求：
 *     1，你设计的矩形页面必须等于给定的目标面积。 2.宽度W不应大于长度L，换言之，要求L>=W。 3，长度L和宽度W之间的差距应当尽可能小。
 * @author: Sxuet
 * @create: 2021-10-18 09:54
 */
public class ConstructRectangle492 {
  /**
   * 从小到大遍历 sqr(area) ，记录l、w，如果差值比记录的小则替换<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 94.99% 的用户
   *
   * @param area
   * @return
   */
  public int[] constructRectangle1(int area) {
    int[] ans = new int[] {1, area};
    for (int w = 1; w * w <= area; w++) {
      if (area % w == 0) {
        int l = area / w;
        if (Math.abs(ans[0] - ans[1]) > Math.abs(l - w)) {
          ans[0] = l;
          ans[1] = w;
        }
      }
    }
    return ans;
  }

  /**
   * 方法一的改造，二分查找。由于需要l w的差值最小，直接从中间开始遍历就可以 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 83.12% 的用户 <br>
   * 比方法一更简洁，执行的更快
   *
   * @param area
   * @return
   */
  public int[] constructRectangle2(int area) {
    int res = (int) Math.sqrt(area);
    while (area % res != 0) {
      --res;
    }
    return new int[] {area / res, res};
  }
}
