package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/7/25
 * @description 面试题 02.03. 删除中间节点
 * @difficulty Easy
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 */
public class RemoveNode {
    /**
     * 这道题居然意思是原地操作节点。。。
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
