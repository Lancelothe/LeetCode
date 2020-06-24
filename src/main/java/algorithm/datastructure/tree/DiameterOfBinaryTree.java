package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/23
 * @description leetcode [543] 二叉树的直径
 * @difficulty Easy
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 */
public class DiameterOfBinaryTree {

    private int res ;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        /**
         *        1
         *       /
         *      2
         *     / \
         *    4   5
         *         \
         *         6
         *        /
         *       8
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        TreeNode t6 = new TreeNode(8);

        t1.left = t2;
        t2.left = t4;
        t2.right = t5;
        t5.right = t3;
        t3.left = t6;
        System.out.println(new DiameterOfBinaryTree()
                .diameterOfBinaryTree(t1));
    }
}
