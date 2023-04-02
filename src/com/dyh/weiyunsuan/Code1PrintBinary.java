package com.dyh.weiyunsuan;

/**
 * @program: mydemo
 * @description: 将int数字打印为二进制输出
 * @author: dyh
 * @date: 2023/03/29 20:00
 * @version: v1.0.0
 */
public class Code1PrintBinary {

    public static void main(String[] args) {
        printBinary(Integer.MIN_VALUE - 1);
        System.out.println();
        System.out.println(Integer.MIN_VALUE - 1);


    }

    /*
     * 00000000000000000000000000000100
     *
     * */
    public static void printBinary(int i) {
        for (int i1 = 31; i1 >= 0; i1--) {
            System.out.print(((i & (1 << i1)) == 0) ? "0" : "1");
        }
    }
}
