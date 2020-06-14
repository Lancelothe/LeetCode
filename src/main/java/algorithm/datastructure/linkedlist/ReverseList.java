package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [206] 翻转链表
 * @difficulty Easy
 * 反转一个单链表。
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
