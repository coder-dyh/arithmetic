package com.dyh.leetcode.tree;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * <a href="https://leetcode.cn/problems/same-tree/">原题地址</a>
 */
public class IsSameTree {


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(0);
        TreeNode q1 = new TreeNode(0);
        TreeNode p2 = new TreeNode(-5);
        TreeNode q2 = new TreeNode(-8);
//        TreeNode p3 = new TreeNode(3);
//        TreeNode q3 = new TreeNode(3);

        p1.left = p2;
//        p1.right = p3;

        q1.left = q2;
//        q1.right = q3;

        System.out.println(isSameTree(p1, q1));
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