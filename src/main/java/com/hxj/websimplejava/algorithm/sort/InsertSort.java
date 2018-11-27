package com.hxj.websimplejava.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author xiangjun.hexj
 * @date 2018/11/14 22:31
 */
public class InsertSort {

    public static void sort(int[] s) {
        int i, j, insertNode;// 要插入的数据

        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < s.length; i++) {
            // 设置数组中的第2个元素为第一次循环要插入的数据
            insertNode = s[i];
            j = i - 1;
            while (j >= 0 && insertNode < s[j]) {
                // 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                s[j + 1] = s[j];
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
            s[j + 1] = insertNode;
        }

    }

    public static void main(String[] args) {
        int a[] = {38, 65, 97, 76, 13, 27, 49};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}