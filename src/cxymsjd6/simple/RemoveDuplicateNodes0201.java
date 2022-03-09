package cxymsjd6.simple;

import struct.ListNode;

import java.util.HashSet;
import java.util.Objects;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * @author Sxuet
 * @since 2021-12-21 11:00
 */
public class RemoveDuplicateNodes0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pre = head;
        while (Objects.nonNull(pre.next)){
            ListNode cur = pre.next;
            if (set.add(cur.val)) {
                pre = pre .next;
            }else {
                pre.next = pre.next.next;
            }
        }

        return head;
    }
}
