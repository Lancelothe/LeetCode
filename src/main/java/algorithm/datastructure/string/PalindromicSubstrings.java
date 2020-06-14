package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2020/2/5
 * @description leetcode [647] 回文子串
 * @difficulty Medium
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class PalindromicSubstrings {
    private static int cnt = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return cnt;
    }

    private static void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
