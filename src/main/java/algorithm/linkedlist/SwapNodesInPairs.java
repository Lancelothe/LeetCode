package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
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
