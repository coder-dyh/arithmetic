package com.dyh.weiyunsuan;

import java.util.Arrays;

/**
 * @program: mydemo
 * @description:
 * @author: dyh
 * @date: 2023/03/31 20:04
 * @version: v1.0.0
 */
public class Code3Leetcode {


    static Code3Leetcode code3Leetcode = new Code3Leetcode();

    public static void main(String[] args) {
//        System.out.println(code3Leetcode.singleNumber2(new int[]{2,2,2,3}));
//        System.out.println(code3Leetcode.hammingWeight(-7));
//        Code1PrintBinary.printBinary(-7);

//        code3Leetcode.printNextNum();

//        System.out.println(code3Leetcode.reverseBits(8));

//        System.out.println(code3Leetcode.isPowerOfTwo(4));

        System.out.println(code3Leetcode.replaceSpace("We are happy."));
    }


    /**
     * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
     * 示例 1：
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * https://leetcode.cn/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int calcTotal = 0;
            for (int num : nums) {
                calcTotal += (num >>> i) & 1;
            }
            if (calcTotal % 3 != 0) {
                res |= 1 << i;
            }
        }

        return res;
    }

    /**
     * https://leetcode.cn/problems/number-of-1-bits/
     *
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        // 0010 0011
        // 0000 0001
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                counter++;
            }
            n >>>= 1;
        }
        return counter;
    }


    /**
     * 京东面试题
     */
    public void printNextNum() {
        String[] strs = new String[11];
        strs[0] = "1";
        strs[1] = "11";
        strs[2] = "21";
        strs[3] = "1211";
        strs[4] = "111221";
        strs[5] = "312211";

        String result = "";

        for (int i = 2; i < 10; i++) {
            result = "";
            int counter = 0;
            String previous = strs[i - 1];
            String current = strs[i];

            for (int j = 0; j < current.length() - 1; j++) {
                if (current.charAt(j) == current.charAt(j + 1)) {
                    counter++;
                } else {
                    counter++;
                    result += counter + "" + current.charAt(j);
                    counter = 0;
                }
            }
            counter++;
            result += counter + "" + current.charAt(current.length() - 1);
            strs[i + 1] = result;
        }

        for (String str : strs) {
            System.out.println(str);
        }
    }


    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     * 输入：n = 00000010100101000001111010011100
     * 输出：964176192 (00111001011110000010100101000000)
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-bits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverseBits(int n) {
        /**
         *
         * 每次循环的时候把n的最后一位数字（二进制的）截取掉，放到一个新的数字中的末尾
         */
        /*int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;*/

        /**
         * 方法二
         * 在java中int类型是32位的，这里用第1位和第32位交换，第2位和第31位交换……最终数字n的高16位会变为低16位，低16位会变为高16位
         */
        int res = 0;
        for (int i = 0; i < 16; i++) {
            res |= (n & 1 << i) << (31 - 2 * i);
        }

        for (int i = 16; i < 32; i++) {
            res |= (n & 1 << i) >>> (i * 2 - 31);
        }
        return res;
    }
    // 0000 1010
    // 0000 0010


    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/power-of-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }


    /**
     *
     作者：AC_OIer
     链接：https://leetcode.cn/problems/missing-number/solution/gong-shui-san-xie-yi-ti-wu-jie-pai-xu-ji-te3s/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        /*Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return 0;*/


        int eor = nums.length;
        for (int num : nums) {
            eor ^= num;
        }

        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        return eor;
    }


    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public String replaceSpace(String s) {
        char[] c = s.toCharArray();
        String res = "";
        for (char c1 : c) {
            if (c1 == ' ') {
                res += "%20";
                continue;
            }
            res += c1;
        }
        return res;
    }

}
