package algorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 【回溯】全排列问题<br>
 * 为了简单清晰起见，这次全排列问题不包含重复的数字。
 *
 * @author Sxuet
 * @since 2022.03.19 18:34
 */
public class FullPermutation {
  /** 结果集 */
  List<List<Integer>> res = new LinkedList<>();

  void backtrack(int[] num, LinkedList<Integer> track) {
    int length = num.length;
    // 结束条件，路径遍历结束后添加到结果集
    if (track.size() == length) {
      res.add(track);
      return;
    }

    // 决策树
    for (int j : num) {
      // 排除不合理的选择
      if (track.contains(j)) {
        continue;
      }
      // 做选择
      track.add(j);
      // 进入下一层决策树
      backtrack(num, track);
      // 取消选择
      track.removeLast();
    }
  }

  /**
   * 主函数，输入一组数据，输出其全排列
   *
   * @param num 一组数据
   * @return 全排列结果res
   */
  public List<List<Integer>> permute(int[] num) {
    /*
     * 选择列表：num
     * 路径： 记录在track中
     * 结束条件 num中的所有数字都出现在track中
     */
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    // 输入选择列表和路径
    backtrack(num, track);
    return res;
  }
}
