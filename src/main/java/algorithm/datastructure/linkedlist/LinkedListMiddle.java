package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [876] 链表的中间结点
 * @difficulty Easy
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LinkedListMiddle {
    /**
     * 思路：快慢指针法
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast.next == null ? slow : slow.next;
    }
}
