package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2020/2/5
 * @description leetcode [409] 最长回文串
 * @difficulty Easy
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] cnt = new int[256];

        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        int palindrome = 0;

        for (int c: cnt) {
            palindrome += (c/2)*2;
        }
        if (palindrome < s.length()) {
            palindrome++;
        }

        return palindrome;
    }

}
