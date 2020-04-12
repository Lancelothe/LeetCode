package algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/12
 * @description leetcode [22] 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParentheses {

    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 0) return res;

        generate(0, 0, n, "");
        return res;
    }

    public void generate(int left, int right, int n, String result) {
        if (left == n && right == n) {
            res.add(result);
            return;
        }

        // 剪枝，left、right代表已经使用了几个左/右括号
        if (left < n)
            generate(left + 1, right, n, result + "(");
        if (right < left && right < n)
            generate(left, right + 1, n, result + ")");
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(3);
        System.out.println(g.res);
    }
}
