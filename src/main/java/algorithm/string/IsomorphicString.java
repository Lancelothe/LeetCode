package algorithm.string;

/**
 * @author lancelot
 * @date 2020/2/5
 * @description leetcode [205]
 */
public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        int[] preSrc = new int[256];
        int[] preTarget = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char src = s.charAt(i), target = t.charAt(i);
            if (preSrc[src] != preTarget[target]) {
                return false;
            }
            preSrc[src] = i+1;
            preTarget[target] = i+1;
        }

        return true;
    }
}
