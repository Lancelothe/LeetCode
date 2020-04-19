package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [61] 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 链接：https://leetcode-cn.com/problems/rotate-list
 */
public class RotateList {

    /**
     * 思路：
     * 1. 求链表长度n，对旋转k对n取余，只需要旋转k%n的位置即可
     * 2. 先用一个指针前行k步，然后另一个指针从头开始，同时前进，当快指针到终点，则慢指针也到了分割点
     * 3. 将快慢指针的next重新指向
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        // 计算链表长度N
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        // 用链表长度N对旋转长度取余，如果大于链表长度，只用旋转 余数个单位即可
        k = k % n;
        if (k == 0) {
            return head;
        }

        ListNode node = head;
        ListNode tmp = head;
        // 向前移动K个位置
        while (k-- > 0) {
            tmp = tmp.next;
        }
        // 如果下一个节点不为NULL，则将头结点和当前结点继续向前移动一步，直到链表结束即尾结点
        while (tmp.next != null) {
            tmp = tmp.next;
            node = node.next;
        }

        // 此时已经直到前后的分割点，tmp和node了，将两段分割的链表重新连接
        tmp.next = head;
        ListNode res = node.next;
        node.next = null;

        return res;
    }
}
