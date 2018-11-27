package com.hxj.websimplejava.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 该排序的基本思想是：
 *
 * 1．先从数列中取出一个数作为基准数。
 *
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 *
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 *
 * @author xiangjun.hexj
 * @date 2018/11/14 20:19
 */
public class QuickSort {

    public static int partition(int[] s, int left, int right) {
        // 基数
        int l = left;
        int r = right;
        int base = s[l];
        while (l < r) {
            // 从右向左找一个小于base的数，来填s[l]
            while (s[r] >= base) {
                r--;
            }
            s[l] = s[r];
            l++;

            // 从左向右找一个大于等于base的数来填s[r]
            while (s[l] < base) {
                l++;
            }
            s[r] = s[l];
            r--;
        }

        s[l] = base;
        return l;
    }

    public static void sort(int[] s, int left, int right) {
        if (left > right) {
            return;
        }
        int i = partition(s, left, right);
        sort(s, left, i - 1);
        sort(s, i + 1, right);
    }

    public static void main(String[] args) {
        int[] s = new int[] {23, 43, 3, -2, 33, 45, -3, 94, 3};
        System.out.println(Arrays.toString(s));
        QuickSort.sort(s, 0, s.length - 1);
        System.out.println(Arrays.toString(s));

    }

}
