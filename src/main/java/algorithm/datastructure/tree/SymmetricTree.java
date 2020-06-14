package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/3/15
 * @description leetcode [101] 对称二叉树
 * @difficulty Easy
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val) && (isSymmetric(left.left, right.right)) && (isSymmetric(left.right, right.left));
    }
}
