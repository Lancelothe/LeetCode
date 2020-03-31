package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [83] 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class RemoveDuplicatedFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            if (p.val == q.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
