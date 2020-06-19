package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/2
 * @description leetcode [328] 奇偶链表
 * @difficulty Medium
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (null == head) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next!= null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}