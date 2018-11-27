package com.hxj.websimplejava.algorithm.sort;

import java.util.Arrays;

/**
 * ��������
 *
 * ������Ļ���˼���ǣ�
 *
 * 1���ȴ�������ȡ��һ������Ϊ��׼����
 *
 * 2���������̣���������������ȫ�ŵ������ұߣ�С�ڻ����������ȫ�ŵ�������ߡ�
 *
 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ������
 *
 * @author xiangjun.hexj
 * @date 2018/11/14 20:19
 */
public class QuickSort {

    public static int partition(int[] s, int left, int right) {
        // ����
        int l = left;
        int r = right;
        int base = s[l];
        while (l < r) {
            // ����������һ��С��base����������s[l]
            while (s[r] >= base) {
                r--;
            }
            s[l] = s[r];
            l++;

            // ����������һ�����ڵ���base��������s[r]
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
