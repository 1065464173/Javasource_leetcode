package simple;

/*
* @Author: Sxuet
* @Date: 2021-06-03 14:56:14
* @LastEditTime: 2021-06-04 14:41:03
* @LastEditors: Sxuet
* @FilePath: /JavaSE_learning/Javasource_leetcode/Reverse7.java
* @Description:
*              给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
*              如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
*              假设环境不允许存储 64 位整数（有符号或无符号）。

*/
public class Reverse7 {
  public static void main(String[] args) {

    int num = reverse(1234135);
    System.out.println(num);
  }

  public static int reverse(int x) {

    int res = 0;
    // int INT_MAX = (int) (Math.pow(2, 31)-1);//2147483647 //Integer.MAX_VALUE

    while (x != 0) {
      int temp = x % 10;
      // 整数越界
      // if (res>(INT_MAX/10)||(res==(INT_MAX/10)&&(temp>INT_MAX%10))) {
      //     return 0 ;
      // }
      // 负数越界
      // if(res<(-INT_MAX/10)||(res==(-INT_MAX/10)&&temp<-(INT_MAX%10-1))){
      //     return 0;
      // }
      if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
        return 0;
      }
      res = res * 10 + temp;
      x /= 10;
    }
    return res;
  }
}
