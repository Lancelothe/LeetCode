package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [86] 分割链表 & 面试题 02.04. 分割链表
 * @difficulty Medium
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 链接：https://leetcode-cn.com/problems/partition-list
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode preHead = new ListNode(0), nextHead = new ListNode(0);
        ListNode pre = preHead, next = nextHead;

        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                next.next = head;
                next = next.next;
            }
            head = head.next;
        }

        next.next = null;
        pre.next = nextHead.next;

        return preHead.next;
    }
}
