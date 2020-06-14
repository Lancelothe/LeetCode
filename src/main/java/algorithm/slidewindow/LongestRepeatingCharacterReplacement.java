package algorithm.slidewindow;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [424] 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 示例 1:
 *
 * 输入:
 * s = "ABAB", k = 2
 *
 * 输出:
 * 4
 *
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 *
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] map = new int[26];
        int maxCount = 0;
        for (; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            map[index]++;
            maxCount = Math.max(maxCount, map[index]);
            if (right - left + 1 > k + maxCount) {
                map[s.charAt(left) - 'A']--;
                left++;
            }

        }

        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement()
                .characterReplacement("AABBBBCCDEF", 1));
    }
}
