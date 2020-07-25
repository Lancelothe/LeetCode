package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2019/5/4
 * @description leetcode [14] 最长公共前缀
 * @difficulty Easy
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class LongestCommonPrefix {

    /**
     * 思路：
     * 取第一个字符串的长度作为基准，一次比较后面的字符串和第一个的每个字符是否相等，返回子串。
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "abe", "abf"};
        System.out.println(longestCommonPrefix(strs));
    }

}
