package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lancelot
 * @date 2020/4/1
 * @description leetcode [199] 二叉树的右视图
 * @difficulty Medium
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *   1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class BinaryTreeRightSideView {

    /**
     * 解法一：BFS
     * 思路：既然是求右视图，则用BFS（广度优先遍历）存每层的最右节点即可。
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return ret;
    }

    /**
     * 解法一：DFS
     * 思路：优先右子树的深度优先遍历，deepest表示目前存的最大深度
     */
    List<Integer> ans = new ArrayList<>();
    int deepest = 0;

    public List<Integer> rightSideViewDFS(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int now) {
        if (root == null) return;
        if (now == deepest) {
            ans.add(root.val);
            deepest++;
        }
        helper(root.right, now + 1);
        helper(root.left, now + 1);
    }

}
