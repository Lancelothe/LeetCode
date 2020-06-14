package algorithm.datastructure.string;

import java.util.HashMap;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [387] 字符串中的第一个唯一字符
 * @difficulty Easy
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FirstUniqueCharInString {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : s.toCharArray()) {
            if (map.get(c).equals(1)) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
