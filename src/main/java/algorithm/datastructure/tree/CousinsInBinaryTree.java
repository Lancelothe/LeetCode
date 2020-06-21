package algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lancelot
 * @date 2020/6/20
 * @description leetcode [993] 二叉树的堂兄弟节点
 * @difficulty Easy
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例：
 *       1
 *      / \
 *     2   3
 *     \    \
 *      4   5
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 */
public class CousinsInBinaryTree {

    /**
     * BFS解法：记录x、y的层数和x、y的父节点，判断他们父节点不同且层数相同才行。
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        int level = 0;
        int xLevel = 0, yLevel = 0;
        TreeNode xParent = null, yParent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (x == node.left.val) {
                        xParent = node;
                        xLevel = level;
                    } else if (y == node.left.val) {
                        yParent = node;
                        yLevel = level;
                    } else {
                        queue.add(node.left);
                    }
                }
                if (node.right != null) {
                    if (x == node.right.val) {
                        xParent = node;
                        xLevel = level;
                    } else if (y == node.right.val) {
                        yParent = node;
                        yLevel = level;
                    } else {
                        queue.add(node.right);
                    }
                }
            }
            level++;
        }

        if (xParent != null && yParent != null && !xParent.equals(yParent) && xLevel == yLevel) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        /**
         *       1
         *      / \
         *     2   3
         *     \    \
         *      4    5
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;


        System.out.println(new CousinsInBinaryTree().isCousins(t1, 3, 4));
    }
}
