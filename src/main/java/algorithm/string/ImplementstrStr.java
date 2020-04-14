package algorithm.string;

/**
 * @author lancelot
 * @date 2020/4/15
 * @description leetcode [28] 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        int N = haystack.length(), L = needle.length();
        for (int i = 0; i < N - L + 1; i++) {
            if (haystack.substring(i, i + L).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementstrStr().strStr("hello", "ll"));
    }
}
