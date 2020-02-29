package algorithm.string;

/**
 * @author lancelot
 * @date 2020/1/27
 */
public class Atoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        long result = 0;
        int sign = 1;

        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            result = result * 10 + (str.charAt(i) - '0');
            if (result > Integer.MAX_VALUE) break;
        }
        if (result != (int) result) {
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) result * sign;
    }

    public static void main(String[] args) {
        int result = myAtoi("18446744073709551617");
        System.out.println(result);
    }
}
