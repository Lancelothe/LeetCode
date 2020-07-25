package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/7/25
 * @description 剑指 Offer 22. 链表中倒数第k个节点 & 面试题 02.02. 返回倒数第 k 个节点
 * @difficulty Easy
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 */
public class GetKthNodeFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }


}
