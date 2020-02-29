package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 */
public class RemoveDuplicatedFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        ListNode p = head;
        while (p!= null && p.next != null) {
            ListNode q = p.next;
            if (p.val == q.val) {
                p.next = q.next;
            } else {
                p = p .next;
            }
        }
        return head;
    }
}
