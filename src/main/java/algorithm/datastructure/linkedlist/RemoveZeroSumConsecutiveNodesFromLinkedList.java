package algorithm.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/7/25
 * @description leetcode [1171] 从链表中删去总和值为零的连续节点
 * @difficulty Medium
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 * 你可以返回任何满足题目要求的答案。
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 *
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    /**
     * 两次Hash存储，后面为0会覆盖前面的，因为有这个条件才能用这个方法：总和 值为 0 的连续节点组成的序列
     * 如果没有这个条件，如[-3, 1, 3 ,2, 1]就不行
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-3);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        System.out.println(new RemoveZeroSumConsecutiveNodesFromLinkedList().removeZeroSumSublists(l1));
    }

}
