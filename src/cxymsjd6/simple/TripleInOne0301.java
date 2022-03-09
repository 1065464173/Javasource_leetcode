package cxymsjd6.simple;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * <p>你应该实现push(stackNum,value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * <p>构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * @author Sxuet
 * @since 2021/12/28 13:20
 */
public class TripleInOne0301 {
  /**
   * 需要考虑栈大小为0的情况<br>
   * 执行用时： 9 ms , 在所有 Java 提交中击败了 98.10% 的用户 内存消耗： 47.5 MB , 在所有 Java 提交中击败了 24.02% 的用户
   */
  private int[] arr = {};

  private int[] size = {};
  private final int stackSize;

  public TripleInOne0301(int stackSize) {
    this.stackSize = stackSize;
    // 第一个栈 [0*stackSize, 1*stackSize)，第二个栈 [1*stackSize, 2*stackSize)，第三个栈 [2*stackSize,
    // 3*stackSize)
    arr = new int[3 * stackSize];
    size = new int[] {0, 0, 0};
  }

  public void push(int stackNum, int value) {
    int length = size[stackNum];
    if (length < stackSize) {
      arr[stackNum * stackSize + length] = value;
      size[stackNum] = length + 1;
    }
  }

  public int pop(int stackNum) {
    int topVal = peek(stackNum);
    if (size[stackNum] > 0) size[stackNum] -= 1;
    return topVal;
  }

  public int peek(int stackNum) {
    if (size[stackNum] == 0) return -1;
    return arr[stackNum * stackSize + size[stackNum] - 1];
  }

  public boolean isEmpty(int stackNum) {
    return size[stackNum] == 0;
  }
}
/*
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
