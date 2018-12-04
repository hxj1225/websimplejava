package com.hxj.websimplejava.algorithm;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @author xiangjun.hexj
 * @date 2018/11/27 17:10
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            while (str.indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String r = LongestCommonPrefix.longestCommonPrefix(new String[] {"flower", "flow", "flight"});
        System.out.println(r);
    }
}
