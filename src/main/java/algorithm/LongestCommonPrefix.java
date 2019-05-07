package algorithm;

/**
 * @author lancelot
 * @date 2019/5/4
 */
public class LongestCommonPrefix {

    /**
     * 思路：
     * 取第一个字符串的长度作为基准，一次比较后面的字符串和第一个的每个字符是否相等，返回子串。
     * @param strArray
     * @return
     */
    private static String longestCommonPrefix(String[] strArray) {
        if (strArray.length == 0) {
            return "";
        }

        for (int i = 0; i < strArray[0].length(); i++) {
            for (String s : strArray) {
                if (i == s.length() || s.charAt(i) != strArray[0].charAt(i)) {
                    return strArray[0].substring(0, i);
                }
            }
        }
        return strArray[0];
    }

    public static void main(String[] args) {
        String[] strArray = {"abc", "abe", "abf"};
        System.out.println(longestCommonPrefix(strArray));
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
