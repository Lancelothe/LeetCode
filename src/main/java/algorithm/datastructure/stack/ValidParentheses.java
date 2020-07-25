package algorithm.datastructure.stack;

import java.util.Stack;

/**
 * @author lancelot
 * @date 2019/5/4
 * @description leetcode [20] 有效的括号
 * @difficulty Easy
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 */
public class ValidParentheses {

    /**
     * 思路：
     * 基本的数据结构——栈的应用，不解释。
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        char[] parentheses = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '{' || parentheses[i] == '[' || parentheses[i] == '(') {
                stack.push(parentheses[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if ((!stack.peek().equals('(') && parentheses[i] == ')') ||
                        (!stack.peek().equals('[') && parentheses[i] == ']') ||
                        (!stack.peek().equals('{') && parentheses[i] == '}')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean b = isValid("(])");
        System.out.println(b);
    }

}
