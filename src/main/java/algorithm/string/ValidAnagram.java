package algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/2/5
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c).intValue() + 1);
        }
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c).intValue() - 1);
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (!m.getValue().equals(0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "car";
        String t = "racc";

        System.out.println(isAnagram(s, t));
    }
}
