package algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/4/9
 * @description leetcode [17] 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {

    private static Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 思路：
     * 排列组合问题。
     * 刚开始想的肯定是一层层循环，但是会随着数字长度越长，循环的层数越多，会呈现指数级增长的复杂度肯定是不优的。
     * 所以采用回溯解法使复杂度尽量减少是关键。
     */
    List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;

        backtrack(digits, "", 0);
        return res;
    }

    public void backtrack(String digits, String combination, int index) {
        if (digits.length() == index) {
            res.add(combination);
            return;
        }

        String letters = phone.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, combination + letters.charAt(i), index + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber t = new LetterCombinationsOfPhoneNumber();
        System.out.println(t.letterCombinations("23"));
    }
}
