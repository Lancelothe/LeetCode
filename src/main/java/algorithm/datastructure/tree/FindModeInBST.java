package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/6/24
 * @description leetcode [501] 二叉搜索树中的众数
 * @difficulty Easy
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 */
public class FindModeInBST {

    private List<Integer> items;
    private int maxCount;
    private int curCount;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        items = new ArrayList<>();
        // 这里设置为1是因为 在递归中 BST中最左边的结点被跳过了，作为初状态 该结点值出现一次，记录的出现最多次数一开始也为1
        maxCount = 1;
        curCount = 1;
        midTraversal(root);
        // 最右端结点的处理，从递归中看，最后一个结点与前一个结点相等只更新了curCount的值；不相等则只考虑到倒数第二个结点。
        if (curCount > maxCount) {
            return new int[]{pre.val};
        }
        if (curCount == maxCount) {
            items.add(pre.val);
        }
        int[] res = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            res[i] = items.get(i);
        }

        return res;
    }

    private void midTraversal(TreeNode node) {
        if (node == null) return;
        midTraversal(node.left);
        if (pre != null) {
            // 第一个节点以后的
            if (node.val != pre.val) {
                // 说明上一个值的结点数量已经统计完成 要看出现次数的情况
                if (curCount > maxCount) {
                    // 出现次数更多，清空之前的出现少的数，更新最大出现次数
                    maxCount = curCount;
                    items.clear();
                    items.add(pre.val);
                } else if (curCount == maxCount) {
                    // 不止一个众数
                    items.add(pre.val);
                }
                // 当前值与上一个结点值不同，重置计数
                curCount = 1;
            } else {
                // 与上一节点相等
                curCount++;
            }

        }
        pre = node;
        midTraversal(node.right);
    }


    public static void main(String[] args) {
        /**
         *        2
         *       / \
         *      1   2
         *     / \   \
         *    1   1   2
         */
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        System.out.println(Arrays.toString(new FindModeInBST().findMode(t1)));
    }
}
