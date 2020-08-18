package algorithm.datastructure.tree;

import algorithm.datastructure.linkedlist.ListNode;

/**
 * @author lancelot
 * @date 2020/3/15
 * @description leetcode [109] 将有序链表转换为二叉搜索树
 * @difficulty Medium
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class ConvertSortedListToBST {

    //时间复杂度：O(nlogn)，其中 n 是链表的长度。
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

    // 时间复杂度：O(n)，其中 n 是链表的长度。
    ListNode cur = null;

    public TreeNode sortedListToBST2(ListNode head) {
        cur = head;
        int end = 0;
        while (head != null) {
            end++;
            head = head.next;
        }
        return sortedArrayToBSTHelper(0, end - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        //遍历左子树并且将根节点返回
        TreeNode left = sortedArrayToBSTHelper(start, mid - 1);
        //遍历当前根节点并进行赋值
        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next; //指针后移，进行下一次的赋值
        //遍历右子树并且将根节点返回
        TreeNode right = sortedArrayToBSTHelper(mid + 1, end);
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        System.out.println(new ConvertSortedListToBST().sortedListToBST2(head));
    }

}
