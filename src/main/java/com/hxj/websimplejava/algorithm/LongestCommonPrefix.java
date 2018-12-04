package com.hxj.websimplejava.algorithm;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 *
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 *
 * ʾ�� 1:
 * ����: ["flower","flow","flight"]
 * ���: "fl"
 *
 * ʾ�� 2:
 * ����: ["dog","racecar","car"]
 * ���: ""
 * ����: ���벻���ڹ���ǰ׺��
 *
 * ˵��:
 * ��������ֻ����Сд��ĸ a-z ��
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
