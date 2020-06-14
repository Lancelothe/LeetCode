package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [125] 验证回文串
 * @difficulty Easy
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (null == s) return false;
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            char i = s.charAt(start);
            char j = s.charAt(end);
            if (!Character.isLetter(i) && !Character.isDigit(i)) {
                start++;
            } else if (!Character.isLetter(j) && !Character.isDigit(j)) {
                end--;
            } else {
                if (i == j) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }
}
