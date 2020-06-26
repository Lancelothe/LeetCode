package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/26
 * @description leetcode [538 & 1038] 把二叉搜索树转换为累加树
 * @difficulty Easy & Medium
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class ConvertBSTToGreaterTree {

    private int num = 0;
    public TreeNode convertBST(TreeNode root) {
        addGreaterVal(root);
        return root;
    }

    private void addGreaterVal(TreeNode node) {
        if (node == null) return;

        addGreaterVal(node.right);
        node.val = node.val + num;
        num = node.val;
        addGreaterVal(node.left);
    }

    public static void main(String[] args) {
        /**
         *        5
         *       / \
         *      2   13
         */
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);

        t1.left = t2;
        t1.right = t3;
        System.out.println(new ConvertBSTToGreaterTree().convertBST(t1));
    }
}
