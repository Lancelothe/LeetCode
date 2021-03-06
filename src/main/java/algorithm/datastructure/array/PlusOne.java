package algorithm.datastructure.array;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/5/31
 * @description leetcode [66] 加一
 * @difficulty Easy
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new PlusOne()
                        .plusOne(new int[]{9, 9, 9})));
    }
}
