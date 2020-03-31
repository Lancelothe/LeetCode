package algorithm.math;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [69] x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 */
public class SqrtX {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 0;
        long right = x / 2;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
