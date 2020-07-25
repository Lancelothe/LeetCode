package algorithm.datastructure.linkedlist;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lancelot
 * @date 2020/7/25
 * @description 剑指 Offer 06. 从尾到头打印链表
 * @difficulty Easy
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 */
public class ReversePrintList {

    /**
     * 栈
     *
     * @param head
     * @return
     */
    public int[] reversePrintStack(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop().val;
        }

        return ans;
    }

    /**
     * 遍历两边：第一遍记录长度，第二遍倒序给数组赋值
     */
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++, head = head.next) {
            ans[length - i - 1] = head.val;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(Arrays.toString(
                new ReversePrintList().reversePrint(l1)
        ));
    }
}
