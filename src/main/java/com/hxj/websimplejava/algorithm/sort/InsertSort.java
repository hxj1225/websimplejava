package com.hxj.websimplejava.algorithm.sort;

import java.util.Arrays;

/**
 * ��������
 *
 * @author xiangjun.hexj
 * @date 2018/11/14 22:31
 */
public class InsertSort {

    public static void sort(int[] s) {
        int i, j, insertNode;// Ҫ���������

        // ������ĵڶ���Ԫ�ؿ�ʼѭ���������е�Ԫ�ز���
        for (i = 1; i < s.length; i++) {
            // ���������еĵ�2��Ԫ��Ϊ��һ��ѭ��Ҫ���������
            insertNode = s[i];
            j = i - 1;
            while (j >= 0 && insertNode < s[j]) {
                // ���Ҫ�����Ԫ��С�ڵ�j��Ԫ��,�ͽ���j��Ԫ������ƶ�
                s[j + 1] = s[j];
                j--;
            }
            // ֱ��Ҫ�����Ԫ�ز�С�ڵ�j��Ԫ��,��insertNote���뵽������
            s[j + 1] = insertNode;
        }

    }

    public static void main(String[] args) {
        int a[] = {38, 65, 97, 76, 13, 27, 49};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}