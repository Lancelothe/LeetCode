package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
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
