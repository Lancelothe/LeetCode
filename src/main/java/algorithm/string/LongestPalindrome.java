package algorithm.string;

/**
 * @author lancelot
 * @date 2020/2/5
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
