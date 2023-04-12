package com.dyh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic
 * @description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dyh
 * @date: 2023/04/08 21:08
 * @version: v1.0.0
 */
public class Code_03_Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    /**
     * 作者：guanpengchn
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (; end < s.length(); end++) {
            char alpha = s.charAt(end);
            if (map.get(alpha) != null) {
                start = Math.max(map.get(alpha), start);
            }
            map.put(alpha, end + 1);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
