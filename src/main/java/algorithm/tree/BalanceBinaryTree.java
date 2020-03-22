package algorithm.tree;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [110] 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class BalanceBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1);
    }

    public int maxDepth(TreeNode node) {
        return node == null ? 0 : (Math.max(maxDepth(node.left), maxDepth(node.right)) + 1);
    }
}
