package algorithm.datastructure.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lancelot
 * @date 2020/7/26
 * @description leetcode [430] 扁平化多级双向链表
 * @difficulty Medium
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 *
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 */
public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node cur, pre = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            cur = stack.pop();
            pre.next = cur;
            cur.prev = pre;

            if (cur.next != null) stack.push(cur.next);
            if (cur.child != null) {
                stack.push(cur.child);
                // don't forget to remove all child pointers.
                cur.child = null;
            }
            pre = cur;
        }

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", prev=" + prev +
                ", next=" + next +
                ", child=" + child +
                '}';
    }
}
