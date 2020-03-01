package algorithm;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [125]
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
