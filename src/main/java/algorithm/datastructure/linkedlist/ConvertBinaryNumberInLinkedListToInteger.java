package algorithm.datastructure.linkedlist;

/**
 * @author lancelot
 * @date 2020/5/31
 * @description leetcode [1290] 二进制链表转整数
 * @difficulty Easy
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 * 示例 1：
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 */
public class ConvertBinaryNumberInLinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int decimal = 0;

        /**
         * 题解中的是运用了反向运算操作，我们在获得二进制的时候是除于2取余数，要计算被除数则是要商乘于2加余数。
         *
         * 例如： 将数字 5 转换为二进制，我们的计算步骤如下：
         *
         * 5 / 2 = 2 ...... 1
         *
         * 2 / 2 = 1 ...... 0
         *
         * 将上面第1步中的除于2移动到等号右边，得到： 5 = （2 * 2）+ 1
         *
         * 以上式子（2 * 2）中，乘号右边的2又可以拆解为： 2 = （2 * 1）+ 0
         *
         * 代入原式子中： 5 = ( 2 * ( ( 2 * 1 ) + 0) ) + 1
         */
        while(head != null){
            decimal = decimal * 2 + head.val;
            head = head.next;
        }

        return decimal;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(new ConvertBinaryNumberInLinkedListToInteger().getDecimalValue(l1));
    }
}
