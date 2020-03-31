package algorithm.math;

/**
 * @author lancelot
 * @date 2020/3/1
 * @description leetcode [50] Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class PowXn {

    // 递归形式，原题n是int型，测试用例里会出现栈溢出，改为long型
    public static double myPow(double x, long n) {
        if (0 == n) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }

        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 4));
    }
}
