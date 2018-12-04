package com.hxj.websimplejava.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 *
 * ʾ�� 1:
 * ����: "()"
 * ���: true
 *
 * ʾ�� 2:
 * ����: "()[]{}"
 * ���: true
 *
 * ʾ�� 3:
 * ����: "(]"
 * ���: false
 *
 * ʾ�� 4:
 * ����: "([)]"
 * ���: false
 *
 * ʾ�� 5:
 * ����: "{[]}"
 * ���: true
 *
 * @author xiangjun.hexj
 * @date 2018/11/27 17:53
 */
public class ValidParentheses {

    Map<Character, Character> map = new HashMap<>();

    public ValidParentheses() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            stack.push(sc[i]);

        }
        return true;
    }
}
