package com.dyh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/11 22:54
 * @version: v1.0.0
 */
public class Code06_Solution {

    public static void main(String[] args) {
        Code06_Solution code06Solution = new Code06_Solution();
        System.out.println(code06Solution.convert("PAYPALISHIRING", 3));
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode.cn/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
