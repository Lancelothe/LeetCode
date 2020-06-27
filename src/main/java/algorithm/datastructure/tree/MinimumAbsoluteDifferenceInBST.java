package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/27
 * @description leetcode [530 & 783] 二叉搜索树的最小绝对差 & 二叉搜索树节点最小距离
 * @difficulty Easy
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 */
public class MinimumAbsoluteDifferenceInBST {

    private int min = Integer.MAX_VALUE;
    private TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        // 判空，寻找最小差值
        if (pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        // 将此节点设置为前一节点
        pre = node;
        inOrder(node.right);
    }

    public static void main(String[] args) {
        /**
         *        3
         *       / \
         *      1   5
         *           \
         *            6
         */
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t3.right = t4;
        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(t1));
    }
}
