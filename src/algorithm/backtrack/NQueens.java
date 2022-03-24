package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 【回溯】N皇后问题
 *
 * <p>给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。
 *
 * <p>PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 *
 * <p>这个问题本质上跟全排列问题差不多，决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
 *
 * @author Sxuet
 * @since 2022.03.20 14:00
 */
public class NQueens {
  /** 结果集 */
  public List<String[][]> res = new ArrayList<>();

  public final String queen = "Q";

  /**
   * 主函数
   *
   * @param n 一个N*N的棋盘
   * @return res 皇后可以放置的所有结果集
   */
  public List<String[][]> permute(int n) {

    // 路径：创建一个n*n的棋盘
    String[][] board = new String[n][n];
    for (String[] b : board) {
      Arrays.fill(b, ".");
    }

    // 输入选择列列表和路径
    backtrack(board, 0);
    return res;
  }

  /**
   * 遍历决策树
   *
   * @param board 棋盘
   * @param row 开始列
   */
  private void backtrack(String[][] board, int row) {
    int length = board.length;
    // 结束条件,输出结果
    if (row == length - 1) {
      for (String[] strings : board) {
        for (String string : strings) {
          System.out.print(string);
        }
        System.out.println();
      }
      System.out.println("-----------------");
      // 浅拷贝 res.add(board); 没法这样使
      return;
    }

    // 决策树
    int n = board[row].length;
    for (int col = 0; col < n; col++) {
      // 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
      // 不能让皇后们互相攻击
      // 排除不符合条件的选择
      if (!isValid(board, row, col)) {
        continue;
      }
      // 添加选择
      board[row][col] = queen;
      // 进入下一层决策树
      backtrack(board, row + 1);
      // 撤销选择
      board[row][col] = ".";
    }
  }

  /**
   * 是否可以在 board[row][col] 放置皇后？
   *
   * @param board 棋盘
   * @param row 行
   * @param col 列
   * @return 是/true 否/false
   */
  private boolean isValid(String[][] board, int row, int col) {
    int n = board.length;
    // 检查列是否有皇后互相冲突
    for (String[] strings : board) {
      if (Objects.equals(strings[col], queen)) {
        return false;
      }
    }
    // 检查右上方是否有皇后互相冲突
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if (Objects.equals(board[i][j], queen)) {
        return false;
      }
    }
    // 检查左上方是否有皇后互相冲突
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (Objects.equals(board[i][j], queen)) {
        return false;
      }
    }
    return true;
  }

  public NQueens() {}

  public static void main(String[] args) {
    NQueens queens = new NQueens();
    List<String[][]> permute = queens.permute(5);
    for (String[][] strings : permute) {
      for (String[] string : strings) {
        for (String s : string) {
          System.out.print(s);
        }
        System.out.println();
      }
    }
  }
}
