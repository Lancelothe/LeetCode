package algorithm.string;

/**
 * @author lancelot
 * @date 2020/2/5
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
