package algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2019/2/24
 * @description leetcode [13] 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 */
public class RomanToInteger {

    /**
     * 除了用Map保存对应关系外，也可以用字符数组保存
     * 如：int tagVal[256];
     *    tagVal['I'] = 1;
     */
    private static Map<Character, Integer> romanToIntegerMap = new HashMap<Character, Integer>(8) {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    /**
     * 解法一： 向后比较法
     * 这个题刚接触时，居然觉得很有难度，那时还是在某公司的三大笔试题之一中首次看到的，后来发现在LeetCode上竟然是easy难度的，赶紧解决之。
     * 刚开始分析时，有点陷入死脑筋的，在想某个数字前后多位的问题，后来发现只要比较相邻两位即可。
     * romanToIntegerMap刚开始用的key是String类型对象的，结果发现转成字符数组后无法获取value，所以将key改成字符类型对象Character。
     * 最后还要关注是否是最后一位数，如果是最后一位数，后面就没有数可比，直接相加。
     * @param roman
     * @return
     */
    private static int romanToInt1(String roman) {
        char[] romans = roman.toCharArray();
        int result = 0;
        for (int i = 0; i < romans.length; i++) {
            if (i == romans.length - 1 ||
                    romanToIntegerMap.get(romans[i]) >= romanToIntegerMap.get(romans[i + 1])) {
                result += romanToIntegerMap.get(romans[i]);
            } else {
                result -= romanToIntegerMap.get(romans[i]);
            }
        }
        return result;
    }

    /**
     * 解法二： 向前比较法
     * 除了与后面的数字比较外，还可以与前面的数字比较
     * 这里需要注意
     * 1、首字符无可比较项，直接相加；
     * 2、如果当前值比前一位值大，则要在结果中减去2倍的前面的值，因为前面先多加了。
     * @param roman
     * @return
     */
    private static int romanToInt2(String roman) {
        char[] romans = roman.toCharArray();
        int result = 0;
        for (int i = 0; i < romans.length; i++) {
            if (i == 0 ||
                    romanToIntegerMap.get(romans[i]) <= romanToIntegerMap.get(romans[i - 1])) {
                result += romanToIntegerMap.get(romans[i]);
            } else {
                result +=  romanToIntegerMap.get(romans[i]) - 2 * romanToIntegerMap.get(romans[i - 1]);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // 输出 1994
        System.out.println(romanToInt2("MCMXCIV"));
        System.out.println(romanToInt1("IVI"));
        System.out.println(romanToInt1("VVVVV"));
    }

    /*
     * @lc app=leetcode id=13 lang=java
     *
     * [13] Roman to Integer
     *
     * https://leetcode.com/problems/roman-to-integer/description/
     *
     * algorithms
     * Easy (51.42%)
     * Total Accepted:    362.4K
     * Total Submissions: 703.8K
     * Testcase Example:  '"III"'
     *
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
     * and M.
     *
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * For example, two is written as II in Roman numeral, just two one's added
     * together. Twelve is written as, XII, which is simply X + II. The number
     * twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is
     * written as IV. Because the one is before the five we subtract it making
     * four. The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     *
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     *
     *
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be
     * within the range from 1 to 3999.
     *
     * Example 1:
     *
     *
     * Input: "III"
     * Output: 3
     *
     * Example 2:
     *
     *
     * Input: "IV"
     * Output: 4
     *
     * Example 3:
     *
     *
     * Input: "IX"
     * Output: 9
     *
     * Example 4:
     *
     *
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     *
     *
     * Example 5:
     *
     *
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     */
}


