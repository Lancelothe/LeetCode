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
    /**
     * 思路：快慢指针法
     * 找到相遇点点后，同时另一个指针从头结点、当前节点从相遇点同时开始移动，两者再次相遇则为入环点。
     *
     * 为什么会相遇呢，设此点为p
     * 设起点到入口为的长度为M, 入口到p的距离为P。环形的周长为c
     * 此时 slow = M+P， fast=M+P+rc。(r为一个变量），也就是当rc = slow时，它们两个会相遇。
     * 此时我们知道的公式为：
     *
     * fast = 2slow
     * slow = M+P
     * fast = 2slow = M+P + slow = M+P+rc
     * 所以slow = rc. M = rc - P = (r-1)c + (c- P), c - P 等于从相遇的p点再走回到环的起点。
     * 因此，我们可以得出一个结论，当在用一个指针ptr，从0开始，走M步到入口时， slow和ptr同时出发，同样走M步（(r-1)c + (c- P)) 也就是走(r-1)圈，然后在加上 c-p步，也就是从相遇到p点回到起点。正好可以和ptr在入口处相遇。
     *
     * 作者：bamboo_cyan
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/kuai-man-zhi-zhen-jie-jue-yue-se-fu-huan-o1kong-ji/
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
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
