package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [524]
 */
public class LongestWordInDictThroughDel {
    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String target: d) {
            int l1 = result.length(), l2 = target.length();
            if (l1> l2 || (l1 == l2 && result.compareTo(target) < 0)) {
                continue;
            }
            if (isSubString(s, target)) {
                result = target;
            }

        }
        return result;
    }

    private static boolean isSubString(String s, String target) {
        int i = 0, j=0;
        while(i < s.length() && j <target.length()) {
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
