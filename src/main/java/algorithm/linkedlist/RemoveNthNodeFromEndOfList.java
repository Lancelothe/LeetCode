package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [19]
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
