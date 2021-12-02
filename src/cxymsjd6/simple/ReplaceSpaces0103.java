package cxymsjd6.simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description URL化。编写一种方法，将字符串中的空格全部替换为20。假定该字符
 *     串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * @since 2021-12-02 14:37
 */
public class ReplaceSpaces0103 {
  /**
   * 执行用时： 33 ms , 在所有 Java 提交中击败了 15.85% 的用户 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 5.04% 的用户
   *
   * @param s
   * @param length
   * @return
   */
  public String replaceSpaces1(String s, int length) {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < length; i++) {
      ans.append(i<s.length()&&s.charAt(i) == ' ' ? "%20" :s.charAt(i));
    }
    return ans.toString();
  }

  /**
   * 双指针
   * @param S
   * @param length
   * @return
   */
  public String replaceSpaces2(String S, int length) {
    char[] chs = S.toCharArray();
    int i = length-1, j = S.length()-1;
    while(i>=0){
      if(chs[i]==' '){
        chs[j--] = '0';
        chs[j--] = '2';
        chs[j--] = '%';
      }else{
        chs[j--] = chs[i];
      }
      i--;
    }
    return String.valueOf(chs,j+1, S.length()-j-1);
  }
}
