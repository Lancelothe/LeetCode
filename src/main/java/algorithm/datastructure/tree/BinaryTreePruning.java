package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [814] 二叉树剪枝
 * @difficulty Medium
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return containOne(root) ? root : null;
    }

    public boolean containOne(TreeNode node) {
        if (node == null) return false;

        boolean left = containOne(node.left);
        boolean right = containOne(node.right);

        if (!left) node.left = null;
        if (!right) node.right = null;

        if (node.val == 1) {
            return true;
        } else {
            return left || right;
        }
    }

}
