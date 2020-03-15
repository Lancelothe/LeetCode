package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2019-12-19
 * @description leetcode [142] 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, pre = head;
        while (fast !=  null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (pre != slow) {
            pre = pre.next;
            slow = slow.next;
        }

        return pre;
    }

    /*
     * @lc app=leetcode id=142 lang=java
     *
     * [142] Linked List Cycle II
     *
     * https://leetcode.com/problems/linked-list-cycle-ii/description/
     *
     * algorithms
     * Medium (30.71%)
     * Total Accepted:    268.1K
     * Total Submissions: 768.7K
     * Testcase Example:  '[3,2,0,-4]\n1'
     *
     * Given a linked list, return the node where the cycle begins. If there is no
     * cycle, return null.
     *
     * To represent a cycle in the given linked list, we use an integer pos which
     * represents the position (0-indexed) in the linked list where tail connects
     * to. If pos is -1, then there is no cycle in the linked list.
     *
     * Note: Do not modify the linked list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * second node.
     *
     *
     *
     *
     * Example 2:
     *
     *
     * Input: head = [1,2], pos = 0
     * Output: tail connects to node index 0
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * first node.
     *
     *
     *
     *
     * Example 3:
     *
     *
     * Input: head = [1], pos = -1
     * Output: no cycle
     * Explanation: There is no cycle in the linked list.
     *
     *
     *
     *
     *
     *
     * Follow-up:
     * Can you solve it without using extra space?
     *
     */
}
