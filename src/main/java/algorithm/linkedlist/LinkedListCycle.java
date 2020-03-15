package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/1/23
 * @description leetcode [141] 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast !=  null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*
     * @lc app=leetcode id=141 lang=java
     *
     * [141] Linked List Cycle
     *
     * https://leetcode.com/problems/linked-list-cycle/description/
     *
     * algorithms
     * Easy (35.54%)
     * Total Accepted:    522.1K
     * Total Submissions: 1.3M
     * Testcase Example:  '[3,2,0,-4]\n1'
     *
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which
     * represents the position (0-indexed) in the linked list where tail connects
     * to. If pos is -1, then there is no cycle in the linked list.
     *
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * second node.
     *
     *
     *
     *
     *
     *
     * Example 2:
     *
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * first node.
     *
     *
     *
     *
     *
     *
     * Example 3:
     *
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     *
     *
     *
     *
     *
     *
     * Follow up:
     *
     * Can you solve it using O(1) (i.e. constant) memory?
     *
     */
}
