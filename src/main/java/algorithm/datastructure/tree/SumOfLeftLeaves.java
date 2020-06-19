package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/19
 * @description leetcode [404] 左叶子之和
 * @difficulty Easy
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 */
public class SumOfLeftLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   5
         *   / \   \
         *  3   4   6
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(t1));
    }
}
