package algorithm.string;

/**
 * @author lancelot
 * @date 2020/2/5
 * @description leetcode [205] 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
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

    public static void main(String[] args) {
        System.out.println(isIsomorphic("add", "egg"));
    }
}
