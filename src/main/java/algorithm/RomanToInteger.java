package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2019/2/24
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
    private static int romanToInt_1(String roman) {
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
    private static int romanToInt_2(String roman) {
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
        System.out.println(romanToInt_2("MCMXCIV"));
        System.out.println(romanToInt_1("IVI"));
        System.out.println(romanToInt_1("VVVVV"));
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


