package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/4/12
 * @description leetcode [138] 复杂链表的复制
 * @difficulty Medium
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 示例1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyListWithRandomPointer {

    /**
     * 哈希的做法，在大多数公司的面试官面前并不是一个满意的答案，
     * 所以需要知道原地修改的解法才能够从容面对面试。 原地修改解法流程：
     *
     * 1. 复制一个新的节点在原有节点之后，如 1 -> 2 -> 3 -> null 复制完就是 1 -> 1 -> 2 -> 2 -> 3 - > 3 -> null
     * 2. 从头开始遍历链表，通过 cur.next.random = cur.random.next 可以将复制节点的随机指针串起来，当然需要判断 cur.random 是否存在
     * 3. 将复制完的链表一分为二 根据以上信息，我们不难写出以下代码
     *
     * 哈希法：空间和时间都是O(n)
     * 原地复制法：空间复杂度为O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        // 复制节点，放在原节点后面
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // 把random指针安排上
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                // 这一步比较难理解，不过画图出来cur.random.next的next就好理解了
                // node.next 是 node 复制出来的节点 ，node.random.next 也是 node.random 复制出来的节点
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 把链表一分为二
        Node copyHead = head.next;
        Node copyNode = copyHead;
        cur = head;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
                copyNode = copyNode.next;
            }
        }

        return copyHead;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
