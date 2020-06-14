package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2020/4/11
 * @description leetcode [6] Z 字形变换
 * @difficulty Medium
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = "";

        int index = 0, flag = -1;

        for (int i = 0; i < s.length(); i++) {
            rows[index] += s.substring(i, i + 1);
            if (index == 0 || index == numRows - 1)
                flag = -flag;
            index += flag;
        }

        String res = "";
        for (String str : rows) res += str;
        return res;
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        System.out.println(z.convert("LEETCODEISHIRING", 3));
    }
}
