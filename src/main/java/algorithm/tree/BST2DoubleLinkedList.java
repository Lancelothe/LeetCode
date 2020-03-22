package algorithm.tree;

import java.util.Stack;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [426](锁定的题目) & 面试题36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class BST2DoubleLinkedList {

    // non-recursion
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node pre = null;
        Node mostRight = root;  //找到最右节点
        while (mostRight.right!=null) {
            mostRight = mostRight.right;
        }

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre == null) {
                root = cur;
            } else {
                cur.left = pre;
                pre.right = cur;
            }
            pre = cur;
            cur = cur.right;
        }

        root.left = mostRight;
        mostRight.right = root;

        return root;
    }

    // recursion
    public Node pre;
    public Node head, tail;

    public Node treeToDoublyList2(Node root) {
        if (root == null) return null;

        recursion(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    public void recursion(Node root) {
        if (root == null) return;

        recursion(root.left);
        root.left = pre;

        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        pre = root;
        tail = root;
        recursion(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
