package com.dyh.leetcode.recursive;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: arithmetic
 * @description: 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * <a href="https://leetcode.cn/problems/decode-string/">原题地址</a>
 * @author: dyh
 * @date: 2023/04/27 20:29
 * @version: v1.0.0
 */
public class StrDecoder {


    public static void main(String[] args) {
        StrDecoder strDecoder = new StrDecoder();
        System.out.println(strDecoder.decodeString2("3[le]"));
    }

    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        int middle = s.length() / 2;
        if (s.charAt(middle) == ']') {
            String tempStr = s.substring(0, middle);
            int index = tempStr.lastIndexOf('[');
            tempStr = tempStr.substring(index);
            int count = (int) s.charAt(index - 1);
            for (int i = 0; i < count; i++) {
                builder.append(tempStr);
            }
        } else if (s.charAt(middle) == '[') {
            String tempStr = s.substring(middle, s.length() - 1);
            int index = tempStr.indexOf(']');
            tempStr = tempStr.substring(middle, index);
            int count = (int) s.charAt(middle - 1);
            for (int i = 0; i < count; i++) {
                builder.append(tempStr);
            }
        } else if (Character.isDigit(s.charAt(middle))) {
            String tempStr = s.substring(middle + 1, s.length() - 1);
            int index = tempStr.indexOf(']');
            tempStr = tempStr.substring(middle + 1, index - 1);
            int count = (int) s.charAt(middle);
            for (int i = 0; i < count; i++) {
                builder.append(tempStr);
            }
        } else {
            if (s.contains("[")) {

            }
        }

        return "";

    }

    /**
     * 作者：jyd
     * 链接：<a href="https://leetcode.cn/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String decodeString1(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();

    }

    /**
     * 作者：jyd
     * 链接：<a href="https://leetcode.cn/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[]{res.toString()};
    }

    public String decodeString3(String s) {
        StringBuilder builder = new StringBuilder();
        int multi = 0;
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = Character.getNumericValue(c) + multi * 10;
            } else if (c == '[') {
                multiStack.push(multi);
                // 保存之前的结果
                strStack.push(builder.toString());
                multi = 0;
                // 重置builder为接下来解密字符串做准备
                builder = new StringBuilder();
            } else if (c == ']') {
                int count = (int) multiStack.pop();
                String str = builder.toString();
                StringBuilder tmpBuilder = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    tmpBuilder.append(str);
                }
                builder = new StringBuilder();
                builder.append(strStack.pop()).append(tmpBuilder);
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
