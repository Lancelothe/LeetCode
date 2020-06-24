package algorithm.math;

/**
 * @author lancelot
 * @date 2020/6/23
 * @description leetcode [67] 二进制求和
 * @difficulty Easy
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (null == a) return b;
        if (null == b) return a;

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            int aVal = a.charAt(a.length() - 1 - i) - '0';
            int bVal = b.charAt(b.length() - 1 - i) - '0';
            int sum = (aVal + bVal + carry) % 2;
            carry = (aVal + bVal + carry) / 2;
            ans.insert(0, sum);
        }

        if (length < a.length()) {
            for (int i = 0; i < a.length() - length; i++) {
                int aVal = a.charAt(a.length() - 1 - length - i) - '0';
                int bVal = 0;
                int sum = (aVal + bVal + carry) % 2;
                carry = (aVal + bVal + carry) / 2;
                ans.insert(0, sum);
            }
        }
        if (length < b.length()) {
            for (int i = 0; i < b.length() - length; i++) {
                int aVal = 0;
                int bVal = b.charAt(b.length() - 1 - length - i) - '0';
                int sum = (aVal + bVal + carry) % 2;
                carry = (aVal + bVal + carry) / 2;
                ans.insert(0, sum);
            }
        }
        if (carry > 0) {
            ans.insert(0, carry);
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }
}
