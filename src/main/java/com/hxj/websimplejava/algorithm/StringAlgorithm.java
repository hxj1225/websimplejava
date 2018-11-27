package com.hxj.websimplejava.algorithm;

import org.springframework.util.Assert;

/**
 * 字符串相关算法
 *
 * @author xiangjun.hexj
 * @date 2018/11/10 11:18
 */
public class StringAlgorithm {

    /**
     * 字符串翻转
     * 汇编语言中有一种移位指令叫做循环左移（ROL），
     * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     * 要求算法复杂度O(n),空间复杂度O(1)
     */
    public static class StringRotation {

        /**
         * 这个算法时间复杂度是O(s.length * k)
         *
         * @param s
         * @param k
         * @return
         */
        public static String leftRotationString(String s, int k) {
            // 获取字符串s的每个字符
            char[] c = s.toCharArray();

            while (k > 0) {
                for (int i = 0; i < s.length() - 1; i++) {
                    // 直接交换的方式，将需要移位的部分通过交换n-1次向左移动
                    // 比如abcde，要移动2位，即cdead
                    // 1. 将a移动至最后，此时是bcdea
                    // 2. 将b移动至最后，此时是cdeab
                    swap(c, i, i + 1);
                }
                k--;
            }
            return new String(c);
        }

        /**
         * 交换位置
         *
         * @param c 字符数组
         * @param m 原位置
         * @param n 新位置
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
