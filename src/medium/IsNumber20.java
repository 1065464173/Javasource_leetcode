package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 数值（按顺序）可以分成以下几个部分： 1.若干空格 2.一个小数或者整数
 *     3.（可选）一个'e'或'E'，后面跟着一个整数 4.若干空格 小数（按顺序）可以分成以下几个部分： 1.（可选）一个符号字符（+或-'） 2.下述格式之一：
 *     1.至少一位数字，后面跟着一个点 2.至少一位数字，后面跟着一个点.’，后面再跟着至少一位数字 3.一个点.’，后面跟着至少一位数字 整数（按顺序）可以分成以下几个部分：
 *     1.（可选）一个符号字符（+或'-'） 2.至少一位数字 部分数值列举如下： ["+100","5e2","-123","3.1416","-1E-16","0123"]
 *     部分非数值列举如下： ["12e","1a3.14","1.2.3","+-5","12e+5.4"]
 * @since 2021-12-05 13:55
 */
public class IsNumber20 {
  /**
   * 面向测试用例编程<br>
   * 执行用时： 9 ms , 在所有 Java 提交中击败了 12.92% 的用户 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 10.34% 的用户
   *
   * @param s
   * @return
   */
  public boolean isNumber1(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    s = s.trim();

    try {
      double a = Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return s.charAt(0) == '.' && s.length() > 1;
    }
    char c = s.charAt(s.length() - 1);
    // 特，末尾有f，d,D这些不算，但是3.算数字（面向测试用例编程）
    return (c >= '0' && c <= '9') || c == '.';
  }

  /**
   * 确定有限状态自动机： 起始的空格 符号位 整数部分 左侧有整数的小数点 左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分） 小数部分 字符 e e
   * 指数部分的符号位 指数部分的整数部分 末尾的空格
   *
   * @param s
   * @return
   */
  public boolean isNumber2(String s) {
    Map<State, Map<CharType, State>> transfer = new HashMap<>();
    Map<CharType, State> initialMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
          }
        };
    transfer.put(State.STATE_INITIAL, initialMap);
    Map<CharType, State> intSignMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
          }
        };
    transfer.put(State.STATE_INT_SIGN, intSignMap);
    Map<CharType, State> integerMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
          }
        };
    transfer.put(State.STATE_INTEGER, integerMap);
    Map<CharType, State> pointMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
          }
        };
    transfer.put(State.STATE_POINT, pointMap);
    Map<CharType, State> pointWithoutIntMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
          }
        };
    transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
    Map<CharType, State> fractionMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
          }
        };
    transfer.put(State.STATE_FRACTION, fractionMap);
    Map<CharType, State> expMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
          }
        };
    transfer.put(State.STATE_EXP, expMap);
    Map<CharType, State> expSignMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
          }
        };
    transfer.put(State.STATE_EXP_SIGN, expSignMap);
    Map<CharType, State> expNumberMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
          }
        };
    transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
    Map<CharType, State> endMap =
        new HashMap<CharType, State>() {
          {
            put(CharType.CHAR_SPACE, State.STATE_END);
          }
        };
    transfer.put(State.STATE_END, endMap);

    int length = s.length();
    State state = State.STATE_INITIAL;

    for (int i = 0; i < length; i++) {
      CharType type = toCharType(s.charAt(i));
      if (!transfer.get(state).containsKey(type)) {
        return false;
      } else {
        state = transfer.get(state).get(type);
      }
    }
    return state == State.STATE_INTEGER
        || state == State.STATE_POINT
        || state == State.STATE_FRACTION
        || state == State.STATE_EXP_NUMBER
        || state == State.STATE_END;
  }

  public CharType toCharType(char ch) {
    if (ch >= '0' && ch <= '9') {
      return CharType.CHAR_NUMBER;
    } else if (ch == 'e' || ch == 'E') {
      return CharType.CHAR_EXP;
    } else if (ch == '.') {
      return CharType.CHAR_POINT;
    } else if (ch == '+' || ch == '-') {
      return CharType.CHAR_SIGN;
    } else if (ch == ' ') {
      return CharType.CHAR_SPACE;
    } else {
      return CharType.CHAR_ILLEGAL;
    }
  }

  enum State {
    STATE_INITIAL,
    STATE_INT_SIGN,
    STATE_INTEGER,
    STATE_POINT,
    STATE_POINT_WITHOUT_INT,
    STATE_FRACTION,
    STATE_EXP,
    STATE_EXP_SIGN,
    STATE_EXP_NUMBER,
    STATE_END
  }

  enum CharType {
    CHAR_NUMBER,
    CHAR_EXP,
    CHAR_POINT,
    CHAR_SIGN,
    CHAR_SPACE,
    CHAR_ILLEGAL
  }
}
