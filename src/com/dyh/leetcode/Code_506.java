package com.dyh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/06 23:58
 * @version: v1.0.0
 */
public class Code_506 {

    public static void main(String[] args) {
        int[] score = new int[]{5, 4, 3, 2, 1};
        Code_506 code506 = new Code_506();
        for (String relativeRank : code506.findRelativeRanks(score)) {
            System.out.println(relativeRank);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        int[] help = Arrays.copyOf(score, score.length);
        Arrays.sort(score);

        Map<Integer, String> map2 = new HashMap<>();
        int j = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            j++;
            if (i == score.length - 1) {
                map2.put(score[i], "Gold Medal");
            } else if (i == score.length - 2) {
                map2.put(score[i], "Silver Medal");
            } else if (i == score.length - 3) {
                map2.put(score[i], "Bronze Medal");
            } else {
                map2.put(score[i], String.valueOf(j));
            }
        }

        String[] res = new String[score.length];
        for (int i = 0; i < help.length; i++) {
            res[i] = map2.get(help[i]);
        }
        return res;
    }
}
