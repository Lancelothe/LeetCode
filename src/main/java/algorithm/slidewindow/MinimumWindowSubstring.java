package algorithm.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [76] 最小覆盖子串
 * @difficulty Hard
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        
        while (right < s.length()) {
            char c1 = s.charAt(right);
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

                if (needs.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (needs.get(s.charAt(left)) > (window.get(s.charAt(left)))) {
                        match--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }


    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring()
                .minWindow("ADOBECODEBANC", "ABC"));
    }
    
}
