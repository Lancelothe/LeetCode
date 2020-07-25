package algorithm.math;

/**
 * @author lancelot
 * @date 2019/2/18
 * @description leetcode [7] 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 */
public class ReserveInteger {

    /**
     * 解法一：
     *      1、对整数转为char数组，首先判断下字符数组索引0是否为'-'（负号）
     *      2、对字符数组进行从尾到头的逆序计算求和，10的N次方（N=索引值）* 字符数组[索引值]，这里需要注意字符数组[索引值]会返回数字的ascii码，这里需要转一下。
     *      3、为负数的再* -1，判断下是否溢出
     *      PS: 这里判断溢出值需要用long型来接收，否则int容不下。
     */
    private static int reverse(int x) {
        String str = String.valueOf(x);
        char[] stringArr = str.toCharArray();
        boolean negative = false;
        if (str.startsWith("-")) {
            negative = true;
            stringArr = str.substring(1).toCharArray();
        }

        int length = stringArr.length;
        long sum = 0;
        while (length-- != 0) {
            sum += Character.getNumericValue(stringArr[length]) * Math.pow(10, length);
        }
        if (negative) {
            sum *= -1;
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            sum = 0;
        }
        return (int) sum;
    }

    /**
     * 解法二：
     *      1、对整数求绝对值，再通过绝对值和原值是否相等判断是否是负数；
     *      2、对绝对值取模相加求翻转的数；
     *      3、翻转后的值乘以负号（如果有的话）判断是否溢出；
     *      PS: 这里判断溢出值需要用long型来接收，否则int容不下。
     */
    private static int reverseNew(int x) {
        int y = Math.abs(x);
        int z = x == y ? 1 : -1;
        long reverse = 0;
        while (y > 0) {
            reverse = reverse * 10 + y % 10;
            y /= 10;
        }

        if (z * reverse > Integer.MAX_VALUE || z * reverse < Integer.MIN_VALUE) {
            reverse = 0;
        }

        return (int) (reverse * z);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverseNew(1534236469));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}

