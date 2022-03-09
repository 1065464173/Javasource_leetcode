package difficult;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。 例如，输入12，1~12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 * @since 2021-12-10 15:23
 */
public class CountDigitOne43 {
  /**
   * 超时了
   *
   * @param n
   * @return
   */
  public int countDigitOne1(int n) {
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
      int temp = i;
      while (temp > 0) {
        ans += temp % 10 == 1 ? 1 : 0;
        temp /= 10;
      }
    }
    return ans;
  }

  private int[] helper = new int[32];
  public int countDigitOne2(int n) {
    if(helper[1]==0){
      //初始化helper数组,helper[1]表示1位数(0-9)中1的个数
      helper[1] = 1;
      for(int i=2;i<=31;i++) {
        helper[i] = helper[i-1]*10 + (int)Math.pow(10,i-1);
      }
    }
    if(n==0) {
      return 0;
    }
    int count = Integer.toString(n).length();
    int a = (int)Math.pow(10,count-1);
    int b = 2*a-1;
    if(n>=b){
      return a + n/a*helper[count-1] + countDigitOne2(n-n/a*a);
    }else{// (n>=a && n<b)
      return helper[count-1] + 1 +(n-a) + countDigitOne2(n-a);
    }
  }
}
