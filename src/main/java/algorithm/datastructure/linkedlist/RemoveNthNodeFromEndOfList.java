package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [19] 删除链表的倒数第N个节点
 * @difficulty Medium
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n-- >0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

}
