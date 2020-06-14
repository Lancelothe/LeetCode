package algorithm.datastructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [524] 通过删除字母匹配到字典里最长单词
 * @difficulty Medium
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class LongestWordInDictThroughDel {
    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String target : d) {
            int l1 = result.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && result.compareTo(target) < 0)) {
                continue;
            }
            if (isSubString(s, target)) {
                result = target;
            }

        }
        return result;
    }

    private static boolean isSubString(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("ale");
        dict.add("apple");
        dict.add("monkey");
        dict.add("plea");
        System.out.println(findLongestWord("abpcplea", dict));
    }
}
