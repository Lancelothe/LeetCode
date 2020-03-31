package algorithm.math;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [633] 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 */
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int end = (int) Math.sqrt(c);
        int start = 0;
        while (start <= end) {
            if (start * start + end * end > c) {
                end--;
            } else if (start * start + end * end < c) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
}
