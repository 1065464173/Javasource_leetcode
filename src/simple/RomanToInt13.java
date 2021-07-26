package simple;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-06-28 10:09
 */
public class RomanToInt13 {
  Map<Character, Integer> map =
      new HashMap<Character, Integer>() {
        {
          put('I', 1);
          put('V', 5);
          put('X', 10);
          put('L', 50);
          put('C', 100);
          put('D', 500);
          put('M', 1000);
        }
      };

  @Test
  public void test01() {
    System.out.println(romanToInt("XXII"));
  }

  public int romanToInt(String s) {
    int ans = map.get(s.charAt(0));
    int n = s.length();
    for (int i = 1; i < n; i++) {
      int value = map.get(s.charAt(i));
      if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
        ans -= value;
      } else {
        ans += value;
      }
    }
    return ans;
  }
}
