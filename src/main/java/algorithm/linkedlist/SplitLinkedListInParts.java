package algorithm.linkedlist;

/**
 * @author lancelot
 * @date 2020/2/2
 * @description leetcode [725]
 */
public class SplitLinkedListInParts {
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
