package algorithm.datastructure.string;

/**
 * @author lancelot
 * @date 2020/8/30
 * @description leetcode [557] 反转字符串中的单词 III
 * @difficulty Easy
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 */
public class ReverseWordsInaStringIII {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ' || i == length - 1) {
                int end = s.charAt(i) == ' ' ? i - 1 : i;
                for (int j = end; j >= start ; j--) {
                    result.append(s.charAt(j));
                }

                if (s.charAt(i) == ' ') {
                    result.append(' ');
                }
                start = i + 1;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(new ReverseWordsInaStringIII().reverseWords(str));
    }
}
