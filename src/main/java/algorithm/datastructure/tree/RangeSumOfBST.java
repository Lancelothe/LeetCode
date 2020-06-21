package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/20
 * @description leetcode [938] 二叉搜索树的范围和
 * @difficulty Easy
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 */
public class RangeSumOfBST {
    private int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    private void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (R > node.val){
                dfs(node.right, L, R);
            }
        }
    }
}
