package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [61] 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        k = k % n;
        if (k == 0) {
            return head;
        }

        ListNode node = head;
        ListNode tmp = head;
        while (k-- > 0) {
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
            node = node.next;
        }

        tmp.next = head;
        ListNode res = node.next;
        node.next = null;

        return res;
    }
}
