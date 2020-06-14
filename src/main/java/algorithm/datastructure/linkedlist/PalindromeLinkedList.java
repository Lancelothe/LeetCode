package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/2
 * @description leetcode [234] 回文链表
 * @difficulty Easy
 * 请判断一个链表是否为回文链表。
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeLinkedList {
    /**
     * 思路：
     * 1. 快慢指针找到中点；
     * 2. 从中点断开分成前后两个链表；
     * 3. 翻转后半段链表；
     * 4. 两个指针分别从前后两个链表头向后移动，逐一比较，都相等，则为true，
     * 注意这里比较是用后半段指针判断下一个节点是否为null，因为后半段链表短，如果总长度是奇数，前半段最后那个是中间节点就不用判断了。
     */
    public static boolean isPalindrome(ListNode head) {
        // 边界条件：空链表或只有一个节点的链表
        if (head == null || head.next == null) {
            return true;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        // 慢指针一次走一步，快指针一次走两步，当快指针走到终点，慢指针刚好处于中点位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // fast指针置于下半段链表的起点
        fast = slow.next;
        // 断开前后两个链表
        slow.next = null;
        // slow指针置于前半段链表的起点
        slow = dummyNode.next;

        // 反转后半段链表
        ListNode pre = null; // 保存指针前一节点的信息，用于反转
        while (fast != null) {
            ListNode nextTemp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = nextTemp;
        }

        // 前后半链表逐一比较，当链表长度为奇数时前半段链表长度比后半段多1，所以以后半段为准
        while (pre != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = null;
        System.out.println(isPalindrome(l1));
    }
}
