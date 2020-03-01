package algorithm;

/**
 * @author lancelot
 * @date 2019/5/4
 * @description leetcode [14]
 */
public class LongestCommonPrefix {

    /**
     * 思路：
     * 取第一个字符串的长度作为基准，一次比较后面的字符串和第一个的每个字符是否相等，返回子串。
     * @param strs
     * @return
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

    /*
     * @lc app=leetcode id=14 lang=java
     *
     * [14] Longest Common Prefix
     *
     * https://leetcode.com/problems/longest-common-prefix/description/
     *
     * algorithms
     * Easy (32.92%)
     * Total Accepted:    451.5K
     * Total Submissions: 1.4M
     * Testcase Example:  '["flower","flow","flight"]'
     *
     * Write a function to find the longest common prefix string amongst an array
     * of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     *
     *
     * Example 2:
     *
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Note:
     *
     * All given inputs are in lowercase letters a-z.
     *
     */
}
