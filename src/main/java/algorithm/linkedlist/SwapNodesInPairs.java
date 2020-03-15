package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [24] 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = pre.next.next;

            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
        }

        return dummy.next;
    }

}
