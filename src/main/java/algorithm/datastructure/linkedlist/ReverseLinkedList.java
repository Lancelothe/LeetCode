package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [206] 翻转链表
 * @difficulty Easy
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {

    /**
     * 迭代解法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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

    /**
     * 递归解法
     */
    public ListNode reverseListRecursion(ListNode node) {
        if (node.next == null) {
            return node;
        }

        // 步骤 1: 先翻转 node 之后的链表
        ListNode newHead = reverseListRecursion(node.next);


        // 步骤 2: 再把原 node 节点后继结点的后继结点指向 node (4)，node 的后继节点设置为空(防止形成环)
        node.next.next = node;
        node.next = null;

        // 步骤 3: 返回翻转后的头结点
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        System.out.println(l1);
        System.out.println(new ReverseLinkedList().reverseListRecursion(l1));
    }
}
