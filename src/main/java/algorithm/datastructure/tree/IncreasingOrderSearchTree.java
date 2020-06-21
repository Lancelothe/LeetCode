package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/6/20
 * @description leetcode [897] 递增顺序查找树
 * @difficulty Easy
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 */
public class IncreasingOrderSearchTree {

    private List<Integer> ans;
    public TreeNode increasingBST(TreeNode root) {
        ans = new ArrayList<>();
        inOrder(root);
        return createOrderTree();
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        ans.add(node.val);
        inOrder(node.right);
    }

    private TreeNode createOrderTree() {
        TreeNode root = null;
        if (!ans.isEmpty()) {
            TreeNode t1 = new TreeNode(ans.get(0));
            root = t1;
            for (int i = 1; i < ans.size(); i++) {
                TreeNode t = new TreeNode(ans.get(i));
                t1.right = t;
                t1 = t1.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        /**
         *        5
         *       / \
         *     3    6
         *    / \    \
         *   2   4    8
         *  /        / \
         * 1        7   9
         */
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t4.left = t7;
        t6.left = t8;
        t6.right = t9;

        System.out.println(new IncreasingOrderSearchTree().increasingBST(t1));
    }

}
