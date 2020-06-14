package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/3/15
 * @description leetcode [235] 二叉搜索树的最近公共祖先
 * @difficulty Easy
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q ) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        //不在左子树，也不在右子树，那说明是根节点
        return root;
    }

}
