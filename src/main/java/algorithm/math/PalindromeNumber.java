package algorithm.math;

/**
 * @author lancelot
 * @date 2019/2/19
 * @description leetcode [9] 回文数
 * @difficulty Easy
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 */
public class PalindromeNumber {

    /**
     * 思路：做过第七题——Reverse Integer后，我们做这道题自然会想到逆序的这个解法，然后判断逆序前后的值是否相等。
     *      并且前提是负数均不为回文数。
     * @param x
     * @return isPalindrome
     */
    public static boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        if (x < 0) {
            return false;
        }
        int y = x;
        int reverse = 0;
        while (y > 0) {
            reverse = reverse * 10 + y % 10;
            y /= 10;
        }

        if (x == reverse) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(PalindromeNumber.isPalindrome(123454321));
    }

}

