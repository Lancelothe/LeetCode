package algorithm.tree;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [559]
 */
public class NAryTreeMaximumDepth {

    public static int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) return maxDepth;

        for (Node node : root.children) {
            int depth = maxDepth(node);
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth + 1;
    }

    public static void main(String[] args) {

    }
}
