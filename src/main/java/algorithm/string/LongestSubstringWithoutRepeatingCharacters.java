package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2019/5/5
 * @description leetcode [3] 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 思路：
     * 在刷LeetCode的题时，也是蛮考验对题目的理解程度的，就像这道题，刚开始对不重复的理解是，只要后一位和前一位不相等就行了.
     * 结果发现不对，要均不重复才行.这道题还是困扰我挺久的，一直在边界问题上，不想对边界单独做判断，参考了一下别人的解法，总结了下下面这种可以归结移动前后两个指针，来判断子串的重复性和长度。
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> charPos = new HashMap<>();

        int max = 0;
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charPos.containsKey(s.charAt(i))) {
                int pos = charPos.get(s.charAt(i)) + 1;
                if (pos > start) {
                    start = pos;
                }
                end++;
                len = end - start;
            } else {
                len++;
                end++;
            }
            charPos.put(s.charAt(i), i);
            max = Math.max(len, max);
        }

        return max;
    }

    /**
     * 思路：
     * 利用map的key-value结构存储值以及对应顺位（下标+1），然后每次指针（j）下移的时候都判断是否已经包含了此字符，如果是则将 i 的值更新，所以每次ans都是取最大的 i 到 j （包括j）的长度。
     * 　　所以而 i 指向的一直是不包含重复的子串开头，而 j 指向就是结尾。ans的每次更新，保证了ans是最大的长度。
     * 　　例如 abcdaa
     * 　　当 j = 4时，发现map内有此时 j 指向的a，所以更新 i 的值，表明之前的a在顺位第 1 个，所以ans就等于新a的位置（j）减去老a的位置（顺位 i -1），所以相当于 j - i +1 = 4。
     * 　　当 j = 5时，发现map内有此时 j 指向的a，所以更新 i 的值，表明之前的a在顺位第 5 个，所以ans_temp = 5-5+1 = 1,取max ，ans最终等于4.
     * 为什么不直接存下标？
     * 　　如果存储的是下标，那么最后更新的ans也只能是 j - i （新位置减去老位置），假如此时整个字符串内都没有重复，那么最后的答案就是length - 1 - 0 ，因为只有当有更新的时候才能下标直接相减。
     *
     * 参考： https://www.cnblogs.com/Xieyang-blog/p/8529870.html
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
//        System.out.println(s.substring(1,2));
    }

    /*
     * @lc app=leetcode id=3 lang=java
     *
     * [3] Longest Substring Without Repeating Characters
     *
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     *
     * algorithms
     * Medium (26.62%)
     * Total Accepted:    898.9K
     * Total Submissions: 3.2M
     * Testcase Example:  '"abcabcbb"'
     *
     * Given a string, find the length of the longest substring without repeating
     * characters.
     *
     *
     * Example 1:
     *
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     *
     *
     * Example 2:
     *
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     *
     *
     * Example 3:
     *
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * ⁠            Note that the answer must be a substring, "pwke" is a
     * subsequence and not a substring.
     *
     *
     *
     *
     */
}
