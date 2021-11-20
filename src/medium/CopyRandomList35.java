package medium;

import struct.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 * @since 2021-11-11 14:17
 */
public class CopyRandomList35 {
  Map<RandomNode, RandomNode> cachedRandomNode = new HashMap<RandomNode, RandomNode>();

  /**
   * 时间复杂度：O（n）,，空间复杂度：O（n）<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 22.77% 的用户
   *
   * @param head
   * @return
   */
  public RandomNode copyRandomList1(RandomNode head) {
    // 终止条件next给过来的node为null
    if (head == null) {
      return null;
    }
    if (!cachedRandomNode.containsKey(head)) {
      // 中间处理方法
      RandomNode copy = new RandomNode(head.val);
      cachedRandomNode.put(head, copy);
      copy.next = copyRandomList1(head.next);
      copy.random = cachedRandomNode.get(head.random);
    }
    return cachedRandomNode.get(head);
  }

  public RandomNode copyRandomList2(RandomNode head) {
    if (head == null) {
      return null;
    }
    RandomNode cur = head;
    // 1. 复制各节点，并构建拼接链表 使得 A->B->C 变为 A->A`->B->B`->C->C`
    while (cur != null) {
      RandomNode tmp = new RandomNode(cur.val);
      tmp.next = cur.next;
      cur.next = tmp;
      cur = tmp.next;
    }

    // 2. 构建各新节点的 random 指向
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    // 3. 拆分两链表
    cur = head.next;
    RandomNode pre = head, res = head.next;
    while (cur.next != null) {
      pre.next = pre.next.next;
      cur.next = cur.next.next;
      pre = pre.next;
      cur = cur.next;
    }
    // 单独处理原链表尾节点
    pre.next = null;
    // 返回新链表头节点
    return res;
  }
}
/*
// Definition for a RandomNode.
class RandomNode {s
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
