package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [160] 相交链表
 * @difficulty Easy
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 思路：
     * 相交链表呈现Y字型，终归有重点，即尾结点为NULL，只是出在前半段两个链表的长度不一致。
     * 1. 分别找到两个链表的长度
     * 2. 用长的 - 短的链表的长度n即为多出来的部分，则让长链表指针先移动n步；
     * 3. 然后两条链表指针同时走，直到相等，则为相遇的交点，如果始终不等，则无交点；
     */

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
