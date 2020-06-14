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

    /*
     * @lc app=leetcode id=9 lang=java
     *
     * [9] Palindrome Number
     *
     * https://leetcode.com/problems/palindrome-number/description/
     *
     * algorithms
     * Easy (41.71%)
     * Total Accepted:    502.9K
     * Total Submissions: 1.2M
     * Testcase Example:  '121'
     *
     * Determine whether an integer is a palindrome. An integer is a palindrome
     * when it reads the same backward as forward.
     *
     * Example 1:
     *
     *
     * Input: 121
     * Output: true
     *
     *
     * Example 2:
     *
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it
     * becomes 121-. Therefore it is not a palindrome.
     *
     *
     * Example 3:
     *
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a
     * palindrome.
     *
     *
     * Follow up:
     *
     * Could you solve it without converting the integer to a string?
     *
     */
}

