package algorithm.string;

/**
 * @author lancelot
 * @date 2020/4/15
 * @description leetcode [38] 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class CountAndSay {
    /**
     * 递归法，有点DP的样子
     */
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        if (n == 1) return "1";

        int cur = 1;
        int start = 0;
        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(cur) != str.charAt(start)) {
                int count = cur - start;
                s.append(count).append(str.charAt(start));
                start = cur;
            }
        }
        if ( start != cur ){// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            int count = cur - start;
            s.append(count).append(str.charAt(start));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
