package algorithm;

/**
 * @author hebohao
 * @date 2019/2/18
 */
public class ReserveInteger {

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
