package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [160] 相交链表 & 剑指 Offer 52. 两个链表的第一个公共节点
 * @difficulty Easy
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
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

    /**
     * 解法二：消除长度差，
     * 如果A为短链表，B为长链表。pA会先到达链表尾，当pA到达末尾时，重置pA为headB；同样的，当pB到达末尾时，重置pB为headA。
     * 当pA与pB相遇时，必然就是两个链表的交点，反之亦然。
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
