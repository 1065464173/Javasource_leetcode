package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: Javasource_leetcode
 * @description: 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *     <p>这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 * @author: Sxuet
 * @create: 2021-08-23 17:57
 */
public class WordPattern290 {

  /**
   * 自创哈希表算法<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.08% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 89.31% 的用户
   *
   * @param pattern
   * @param s
   * @return
   */
  public boolean wordPattern1(String pattern, String s) {
    String[] words = s.split(" ");
    // 字符和单词是互相映射，数量必须相等
    if (words.length != pattern.length()) {
      return false;
    }
    HashMap<String, String> map = new HashMap<>();
    // 设置两个指针，一个遍历s，一个遍历pattern
    int i = 0, j = 0;
    while (i < s.length()) {
      // s2 为获取pattern的一个格式字符
      String s2 = String.valueOf(pattern.charAt(j++));

      // 遍历出第一个单词，分隔符为空格
      StringBuilder sb1 = new StringBuilder();
      while (i < s.length() && s.charAt(i) != ' ') {
        sb1.append(s.charAt(i++));
      }
      String s1 = sb1.toString();

      // 比较hash表内是否存在pattern对应的key
      if (map.containsKey(s2)) {
        // 如果存在其值是否是当下遍历出来的单词，不是的话false
        if (!map.get(s2).equals(s1)) {
          return false;
        }
      } else if (map.containsValue(s1)) {
        // 如果已经存在值，则证明其值之前记录的key与当前key不匹配，返回false
        return false;
      } else {
        // 不存在则添加
        map.put(s2, s1);
      }
      i++;
    }
    return true;
  }

  /**
   * 高赞答案 简洁多了<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.08% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 68.37% 的用户
   *
   * @param pattern
   * @param s
   * @return
   */
  public boolean wordPattern2(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }
    /*
        如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

        以pattern = "abba", str = "dog cat cat dog"为例，
        第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
        第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
        第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
        第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
        结果为 true。

        以pattern = "abba", str = "dog cat cat fish"为例，
        第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
        第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
        第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
        第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
        结果为 false。
    */
    Map<Object, Integer> map = new HashMap<>();
    for (Integer i = 0; i < words.length; i++) {
      if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(words[i], i))) {
        return false;
      }
    }
    return true;
  }
}
