package com.dyh.leetcode.recursive;

import java.util.Arrays;

public class PredictTheWinner {

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner2(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner1(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner3(new int[]{1, 5, 233, 7}));
    }

    public static boolean predictTheWinner(int[] nums) {
        int[][] mem = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(mem[i], Integer.MIN_VALUE);
        }
        return dsfSearch(nums, 0, nums.length - 1, mem) >= 0;
    }

    public static int dsfSearch(int[] nums, int i, int j, int[][] mem) {
        if (i > j) {
            return 0;
        }
        if (mem[i][j] != Integer.MIN_VALUE) {
            return mem[i][j];
        }
        mem[i][j] = Math.max(nums[i] - dsfSearch(nums, i + 1, j, mem), nums[j] - dsfSearch(nums, i, j - 1, mem));
        return mem[i][j];
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static boolean predictTheWinner1(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public static int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }


    public static boolean predictTheWinner2(int[] nums) {
        return getScore(nums, 0, nums.length - 1) >= 0;
    }

    private static int getScore(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(nums[i] - getScore(nums, i + 1, j), nums[j] - getScore(nums, i, j - 1));
    }


    /**
     * 作者：liweiwei1419
     * 链接：<a href="https://leetcode.cn/problems/predict-the-winner/solution/ji-yi-hua-di-gui-dong-tai-gui-hua-java-by-liweiwei/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static boolean predictTheWinner3(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, len - 1, memo) >= 0;
    }

    private static int dfs(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        int chooseLeft = nums[i] - dfs(nums, i + 1, j, memo);
        int chooseRight = nums[j] - dfs(nums, i, j - 1, memo);
        memo[i][j] = Math.max(chooseLeft, chooseRight);
        return memo[i][j];
    }

}