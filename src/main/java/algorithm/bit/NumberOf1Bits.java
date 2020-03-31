package algorithm.bit;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [191] 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class NumberOf1Bits {

    /**
     * 思路：
     * 解法一：
     * 对于一个数，将n和n-1进行&运算，都可以把n中的最低位的1消为0。
     * 用上面这个特性，当n！=0时，一直循环进行这个&运算。
     *
     * 解法二：
     * n是int类型的，所以最多32位，也就32个1，可以比较看看每1位是不是1.
     * 用一个变量mask初始化是1，mask&n看看mask的那一位是不是1，然后mask左移mask = mask << 1，继续比较，循环32次。
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & n - 1;
        }

        return count;
    }


}
