package com.dyh.zuochengyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/23 20:42
 * @version: v1.0.0
 */
public class PreInPostPrintBinaryTree {

    public static void main(String[] args) {
        PreInPostPrintBinaryTree executor = new PreInPostPrintBinaryTree();

    }

    /**
     * 先序遍历（父->左->右）
     *
     * @param root
     */
    public void preUnRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.println("preUnRecur: ");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历（左->父->右）
     *
     * @param root
     */
    public List<Integer> inUnRecur(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }

    /**
     * 后序遍历（左->右->父）
     *
     * @param root
     */
    public void postUnRecur(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);
                if (root.left != null) {
                    s1.push(root.left);
                }
                if (root.right != null) {
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()) {
                list.add(s2.pop().val);
            }
        }

    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
