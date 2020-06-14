package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/2
 * @description leetcode [725] 分隔链表
 * @difficulty Medium
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class SplitLinkedListInParts {
    /**
     * 思路
     * 1.计算链表总长度
     * 2.通过链表长度sum和拆分个数k，计算出拆分后链表的长度num
     * 3.对分链表进行赋值，分链表走过num后添加null进行截断
     * 4.返回链表数组
     *
     * 作者：1905215165
     * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts/solution/java-jian-dan-yi-dong-by-1905215165-2/
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode head = root;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        int size = length / k;
        int mod = length % k;
        ListNode cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            result[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
    }

}
