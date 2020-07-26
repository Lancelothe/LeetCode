package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/7/26
 * @description leetcode [707] 设计链表
 * @difficulty Medium
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 */
public class DesignLinkedList {


}

class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
            prev = null;
            next = null;
        }

        public ListNode() {
            val = 0;
            prev = null;
            next = null;
        }
    }

    int length = 0;
    ListNode head, tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= length) return -1;

        ListNode pre;
        if (index < length - index) {
            pre = head;
            for (int i = 0; i < index + 1; i++) {
                pre = pre.next;
            }
        } else {
            pre = tail;
            for (int i = 0; i < length - index; i++) {
                pre = pre.prev;
            }
        }
        return pre.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        } else if (index > length) return;

        ListNode pre;
        if (index < length - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode node = new ListNode(val);
            node.prev = pre;
            node.next = pre.next;
            pre.next.prev = node;
            pre.next = node;
        } else {
            pre = tail;
            for (int i = 0; i < length - index; i++) {
                pre = pre.prev;
            }
            ListNode node = new ListNode(val);
            node.next = pre;
            node.prev = pre.prev;
            pre.prev.next = node;
            pre.prev = node;
        }
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;

        ListNode pre;
        if (index < length - index) {
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next.next.prev = pre;
            pre.next = pre.next.next;
        } else {
            pre = tail;
            for (int i = 0; i < length - index - 1; i++) {
                pre = pre.prev;
            }

            pre.prev.prev.next = pre;
            pre.prev = pre.prev.prev;
        }
        length--;
    }
}

