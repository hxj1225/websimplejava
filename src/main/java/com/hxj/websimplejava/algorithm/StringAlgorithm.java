package com.hxj.websimplejava.algorithm;

import org.springframework.util.Assert;

/**
 * �ַ�������㷨
 *
 * @author xiangjun.hexj
 * @date 2018/11/10 11:18
 */
public class StringAlgorithm {

    /**
     * �ַ�����ת
     * �����������һ����λָ�����ѭ�����ƣ�ROL����
     * �����и��򵥵����񣬾������ַ���ģ�����ָ�����������
     * ����һ���������ַ�����S���������ѭ������Kλ������������
     * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
     * Ҫ���㷨���Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    public static class StringRotation {

        /**
         * ����㷨ʱ�临�Ӷ���O(s.length * k)
         *
         * @param s
         * @param k
         * @return
         */
        public static String leftRotationString(String s, int k) {
            // ��ȡ�ַ���s��ÿ���ַ�
            char[] c = s.toCharArray();

            while (k > 0) {
                for (int i = 0; i < s.length() - 1; i++) {
                    // ֱ�ӽ����ķ�ʽ������Ҫ��λ�Ĳ���ͨ������n-1�������ƶ�
                    // ����abcde��Ҫ�ƶ�2λ����cdead
                    // 1. ��a�ƶ�����󣬴�ʱ��bcdea
                    // 2. ��b�ƶ�����󣬴�ʱ��cdeab
                    swap(c, i, i + 1);
                }
                k--;
            }
            return new String(c);
        }

        /**
         * ����λ��
         *
         * @param c �ַ�����
         * @param m ԭλ��
         * @param n ��λ��
         */
        public static void swap(char[] c, int m, int n) {
            char temp = c[m];
            c[m] = c[n];
            c[n] = temp;
        }

        public static String leftRotationString2(String s, int k) {
            char[] c = s.toCharArray();

            reverse(c, 0, k - 1);
            reverse(c, k, c.length - 1);
            reverse(c, 0, c.length - 1);
            return new String(c);
        }

        public static void reverse(char[] str, int start, int end) {
            while (start < end) {
                swap(str, start, end);
                start++;
                end--;
            }
        }

        public static void main(String[] args) {
            String s = StringRotation.leftRotationString2("abcXYZdef", 3);
            Assert.isTrue(s.equals("XYZdefabc"));
            System.out.println(s);
        }

    }
}
