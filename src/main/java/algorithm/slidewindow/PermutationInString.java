package algorithm.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [567] 字符串的排列
 * @difficulty Medium
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (needs.get(c1).equals(window.get(c1))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = end - start;
                }
                char c2 = s2.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (needs.get(c2) > (window.get(c2))) {
                        match--;
                    }
                }

                left++;
            }
        }

        return minLen == s1.length();
    }


    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }

}
