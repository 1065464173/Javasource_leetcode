package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个数组A【0，1，…，n-1】，请构建一个数组B【0，1，…，n-1】，其中B【i】的值是数组A中除了下标i以外的元素的积，
 *     即B【i】=A【0】×A【1】×…×A【i-1】×A【i+1】×…×A【n-1】。不能使用除法。
 * @since 2021-12-02 09:49
 */
public class ConstructArr66 {
  /**
   * 暴力解法 超时时间限制
   *
   * @param a
   * @return
   */
  public int[] constructArr1(int[] a) {
    int length = a.length;
    int[] b = new int[length];
    for (int i = 0; i < length; i++) {
      int mul = 1;
      for (int j = 0; j < length; j++) {
        if (j == i) {
          continue;
        }
        mul *= a[j];
      }
      b[i] = mul;
    }
    return b;
  }

  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 51.2 MB , 在所有 Java 提交中击败了 23.78% 的用户
   *
   * @param a
   * @return
   */
  public int[] constructArr2(int[] a) {
    int len = a.length;
    if (len == 0) {
      return new int[0];
    }
    int[] b = new int[len];
    b[0] = 1;
    int tmp = 1;
    for (int i = 1; i < len; i++) {
      b[i] = b[i - 1] * a[i - 1];
    }
    for (int i = len - 2; i >= 0; i--) {
      tmp *= a[i + 1];
      b[i] *= tmp;
    }
    return b;
  }

  /**
   * @param a
   * @return
   */
  public int[] constructArr3(int[] a) {
    int n = a.length;
    int[] B = new int[n];
    /* 从左往右累乘 */
    for (int i = 0, product = 1; i < n; product *= a[i], i++) {
      B[i] = product;
    }
    /* 从右往左累乘 */
    for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--) {
      B[i] *= product;
    }
    return B;
  }
}
