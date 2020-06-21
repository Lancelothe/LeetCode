package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/20
 * @description leetcode [965] 单值二叉树
 * @difficulty Easy
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;

        return root.val == val && isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }


    public static void main(String[] args) {
        /**
         *        1
         *       / \
         *      1   1
         *     / \   \
         *    1   1   1
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;


        System.out.println(new UnivaluedBinaryTree().isUnivalTree(t1));
    }
}
