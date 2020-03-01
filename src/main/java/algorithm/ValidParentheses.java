package algorithm;

import java.util.Stack;

/**
 * @author lancelot
 * @date 2019/5/4
 * @description leetcode [20]
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

    /*
     * @lc app=leetcode id=20 lang=java
     *
     * [20] Valid Parentheses
     *
     * https://leetcode.com/problems/valid-parentheses/description/
     *
     * algorithms
     * Easy (35.78%)
     * Total Accepted:    572.8K
     * Total Submissions: 1.6M
     * Testcase Example:  '"()"'
     *
     * Given a string containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     *
     * Input: "()"
     * Output: true
     *
     *
     * Example 2:
     *
     *
     * Input: "()[]{}"
     * Output: true
     *
     *
     * Example 3:
     *
     *
     * Input: "(]"
     * Output: false
     *
     *
     * Example 4:
     *
     *
     * Input: "([)]"
     * Output: false
     *
     *
     * Example 5:
     *
     *
     * Input: "{[]}"
     * Output: true
     *
     *
     */
}
