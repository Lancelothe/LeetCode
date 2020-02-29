package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/1/23
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    /*
     * @lc app=leetcode id=21 lang=java
     *
     * [21] Merge Two Sorted Lists
     *
     * https://leetcode.com/problems/merge-two-sorted-lists/description/
     *
     * algorithms
     * Easy (45.58%)
     * Total Accepted:    813.6K
     * Total Submissions: 1.6M
     * Testcase Example:  '[1,2,4]\n[1,3,4]'
     *
     * Merge two sorted linked lists and return it as a new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     *
     */
}
