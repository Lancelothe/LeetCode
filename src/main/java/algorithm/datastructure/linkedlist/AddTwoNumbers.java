package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2019/5/5
 * @description leetcode [2] 两数相加
 * @difficulty Medium
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    /**
     * 思路：
     * 链表的基本操作，回顾下数据结构里的链表操作，需要注意的是不能直接操作链表的引用，而是要用指针指向他，操作指针。
     * 最后返回时去掉了创建时虚拟的头结点的val，而直接返回子链表。
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int carry = 0;


        while (p != null || q != null) {
            int v1 = (p != null) ? p.val : 0;
            int v2 = (q != null) ? q.val : 0;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);

        l10.next = l11;
        l11.next = l12;
        l12.next = null;

        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l20.next = l21;
        l21.next = l22;
        l22.next = null;

        System.out.println(addTwoNumbers(l10, l20));
    }
    /*
     * @lc app=leetcode id=2 lang=java
     *
     * [2] Add Two Numbers
     *
     * https://leetcode.com/problems/add-two-numbers/description/
     *
     * algorithms
     * Medium (30.48%)
     * Total Accepted:    849.9K
     * Total Submissions: 2.7M
     * Testcase Example:  '[2,4,3]\n[5,6,4]'
     *
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their nodes
     * contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     *
     * Example:
     *
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     *
     */
}
