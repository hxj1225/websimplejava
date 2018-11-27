package com.hxj.websimplejava.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
 *
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
 *
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ
 * IX���������Ĺ���ֻ�������������������
 *
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
 *
 * ʾ�� 1:
 * ����: "III"
 * ���: 3
 *
 * ʾ�� 2:
 * ����: "IV"
 * ���: 4
 *
 * ʾ�� 3:
 * ����: "IX"
 * ���: 9
 *
 * ʾ�� 4:
 * ����: "LVIII"
 * ���: 58
 * ����: L = 50, V= 5, III = 3.
 *
 * ʾ�� 5:
 * ����: "MCMXCIV"
 * ���: 1994
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author xiangjun.hexj
 * @date 2018/11/26 21:02
 */
public class RomanToInteger {

    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))) {
                num += map.get(s.charAt(i));
            } else {
                num = num - 2 * map.get(s.charAt(i - 1)) + map.get(s.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int a = solution("MCMXCIV");
        System.out.println(a);
    }
}
