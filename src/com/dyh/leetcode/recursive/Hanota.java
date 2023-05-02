package com.dyh.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic
 * @description: 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <a href="https://leetcode.cn/problems/hanota-lcci/">原题地址</a>
 * <p>
 * 你需要原地修改栈。
 * @author: dyh
 * @date: 2023/04/30 11:49
 * @version: v1.0.0
 */
public class Hanota {

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(5);
        listA.add(4);
        listA.add(3);
        listA.add(2);
        listA.add(1);
        hanota(listA, new ArrayList<Integer>(), res);
        System.out.println(res);
    }

    /**
     * 作者：lan-ch
     * 链接：<a href="https://leetcode.cn/problems/hanota-lcci/solution/mian-shi-ti-0806yi-nuo-ta-wen-ti-si-lu-f-ajwe/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param A
     * @param B
     * @param C
     */
    public static void hanota1(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlant(A.size(), A, B, C);
    }

    //size 需要移动的盘子的数量
    //start 起始的柱子
    //auxiliary 辅助柱子
    //target 目标柱子
    public static void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
        //当只剩一个盘子时，直接将它从第一个柱子移动到第三个柱子
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        //首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
        movePlant(size - 1, start, target, auxiliary);
        //然后将最后一个盘子移动到第三个柱子上
        target.add(start.remove(start.size() - 1));
        //最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
        movePlant(size - 1, auxiliary, start, target);

    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        recurMovePlant(A.size(), A, B, C);
    }


    public static void recurMovePlant(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 将 n-1 个盘子放到B中
        recurMovePlant(size - 1, A, C, B);
        // 将第 n 个盘子放到C中
        C.add(A.remove(A.size() - 1));
        // 将B中的盘子放到C中
        recurMovePlant(size - 1, B, A, C);
    }


    public static void recurMovePlant1(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 将 n-1 个盘子放到B中
        B.add(A.remove(A.size() - 1));
        // 将第 n 个盘子放到C中
        C.add(A.remove(A.size() - 1));
        // 将B中的盘子放到C中
        C.add(A.remove(B.size() - 1));
        recurMovePlant1(size - 2, A, B, C);
    }

}
