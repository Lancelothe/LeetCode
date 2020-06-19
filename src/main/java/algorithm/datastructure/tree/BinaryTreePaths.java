package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/6/19
 * @description leetcode [257] 二叉树所有路径
 * @difficulty Easy
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 */
public class BinaryTreePaths {

    /**
     * 回溯解法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(root, ans, path);
        return ans;
    }

    private static void dfs(TreeNode node, List<String> ans, List<String> path) {
        if (node == null) return;

        path.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
//            ans.add(StringUtils.join(path, "->"));
            ans.add(joinString(path, "->"));
            path.remove(path.size() - 1);
            return;
        }

        dfs(node.left, ans, path);
        dfs(node.right, ans, path);
        path.remove(path.size() - 1);
    }

    private static String joinString(List<String> path, String patter) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            res.append(path.get(i)).append(patter);
        }
        if (!path.isEmpty()) {
            res.append(path.get(path.size()-1));
        }
        return res.toString();
    }


    public static void main(String[] args) {
//        /**
//         *      1
//         *     / \
//         *    2   5
//         *   / \   \
//         *  3   4   6
//         */
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//
//        t1.left = t2;
//        t1.right = t5;
//        t2.left = t3;
//        t2.right = t4;
//        t5.right = t6;

        /**
         *      1
         *     / \
         *    2   3
         *    \
         *     5
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t5;

        System.out.println(new BinaryTreePaths().binaryTreePaths(t1));
    }
}
