package algorithm.tree;

import algorithm.linkedlist.ListNode;

/**
 * @author lancelot
 * @date 2020/3/15
 * @description leetcode [109] 将有序链表转换为二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
