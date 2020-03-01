package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/2
 * @description leetcode [328]
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (null == head) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next!= null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}
