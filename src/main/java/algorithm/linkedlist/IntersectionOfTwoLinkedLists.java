package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            lengthA++;
            p = p.next;
        }
        while (q != null) {
            lengthB++;
            q = q.next;
        }
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

}
