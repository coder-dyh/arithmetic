package com.dyh.leetcode;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/13 22:26
 * @version: v1.0.0
 */
public class Jianzhi04_Solution {

    public static void main(String[] args) {
        Jianzhi04_Solution jianzhi04Solution = new Jianzhi04_Solution();
//        jianzhi04Solution.findNumberIn2DArray()
    }

    /**
     * 作者：na202
     * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/hua-jie-suan-fa-si-lu-python3dai-ma-shi-dcmgo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }


}
