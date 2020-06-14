package algorithm.datastructure.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [345] 转字符串中的元音字母
 * @difficulty Easy
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowelsOfAString {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if (s == null) return null;
        int start = 0;
        int end = s.length() - 1;
        char[] result = new char[s.length()];
        while (start <= end) {
            char p = s.charAt(start);
            char q = s.charAt(end);
            if (!vowels.contains(q)) {
                result[end--] = q;
            } else if (!vowels.contains(p)) {
                result[start++] = p;
            } else {
                result[start++] = q;
                result[end--] = p;
            }
        }

        return new String(result);
    }


    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));

    }
}
