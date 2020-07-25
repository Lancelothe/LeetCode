package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [82] 删除排序链表中的重复元素 II
 * @difficulty Medium
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatedFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;

        ListNode virtual = new ListNode(0);
        ListNode res = virtual;
        virtual.next = head;
        while (virtual.next != null && virtual.next.next != null) {
            ListNode p = virtual.next;
            ListNode q = virtual.next.next;
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                virtual.next = q;
            } else {
                virtual = virtual.next;
            }
        }

        return res.next;
    }

}
