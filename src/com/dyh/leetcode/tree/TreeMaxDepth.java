package com.dyh.leetcode.tree;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">原题地址</a>
 */
public class TreeMaxDepth {

    static int calcDepth(TreeNode root, int h) {
        if (root == null) {
            return 0;
        }
        h = h + 1;
        return Math.max(calcDepth(root.left, h), calcDepth(root.right, h));
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}