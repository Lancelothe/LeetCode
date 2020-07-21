package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/7/21
 * @description leetcode [143] 重排链表
 * @difficulty Medium
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 链接：https://leetcode-cn.com/problems/reorder-list
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 快慢指针找到中点
        ListNode slow = head, fast = head, left = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 记录后半段链表的起点
        ListNode mid = slow.next;
        // 断开链表为前后两个
        slow.next = null;
        // 翻转后半段链表
        ListNode right = reverse(mid);
        // 合并前后两段链表
        merge(left, right);
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        ListNode cur1 = h1, cur2 = h2;
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next, next2 = cur2.next;
            cur1.next = cur2;
            if (next1 != null) {
                cur2.next = next1;
            }
            cur1 = next1;
            cur2 = next2;
        }

        return h1;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        new ReorderList().reorderList(l1);

//        System.out.println(new ReorderList().merge(l1, l4));

    }
}
