package algorithm.datastructure.string;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [344] 反转字符串
 * @difficulty Easy
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 链接：https://leetcode-cn.com/problems/reverse-string
 */
public class ReverseString {
    /**
     * 解法：从两边往中间，进行两两交换
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        String s = "1234567";
        new ReverseString().reverseString(s.toCharArray());
    }
}
