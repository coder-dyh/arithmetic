package com.dyh.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;

public class PreInPostPrintBinaryTree {


    public static List<Integer> preOrderRecur(TreeNode head, List<Integer> list) {
        if (head == null) {
            return list;
        }
        list.add(head.val);
        preOrderRecur(head.left, list);
        preOrderRecur(head.right, list);
        return list;
    }

    public static void main(String[] args) {

    }

    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * https://leetcode.cn/problems/binary-tree-preorder-traversal/
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrderRecur(root, new ArrayList<>());
    }

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return inOrderRecur(root, new ArrayList<>());
    }

    public List<Integer> inOrderRecur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inOrderRecur(root.left, list);
        list.add(root.val);
        inOrderRecur(root.right, list);

        return list;
    }

    /**
     * https://leetcode.cn/problems/binary-tree-postorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrderRecur(root, new ArrayList<>());
    }

    public List<Integer> postOrderRecur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        postOrderRecur(root.left, list);
        postOrderRecur(root.right, list);
        list.add(root.val);

        return list;
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