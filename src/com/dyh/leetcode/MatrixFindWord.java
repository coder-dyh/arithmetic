package com.dyh.leetcode;

/**
 * @program: arithmetic
 * @description: 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/">...</a>
 * @author: dyh
 * @date: 2023/04/24 21:18
 * @version: v1.0.0
 */
public class MatrixFindWord {

    public static void main(String[] args) {

    }

    /**
     * 作者：jyd
     * 链接：<a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    public boolean exist1(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dsfSearch(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dsfSearch(char[][] board, int i, int j, char[] word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        // 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问
        board[i][j] = '\0';
        boolean res = dsfSearch(board, i - 1, j, word, k + 1) || dsfSearch(board, i + 1, j, word, k + 1) || dsfSearch(board, i, j - 1, word, k + 1) || dsfSearch(board, i, j + 1, word, k + 1);
        // 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
        board[i][j] = word[k];
        return res;
    }

}
