package com.hxj.websimplejava.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ�� ���� ������
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 *
 * @author xiangjun.hexj
 * @date 2018/11/26 19:59
 */
public class TwoSum {

    /**
     * ʱ�临�Ӷ� O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * ʱ�临�Ӷ�O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.get(a) != null) {
                return new int[] {map.get(a), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 6, 7, 4, 1};
        int[] r = twoSum(nums, 3);
        System.out.println(Arrays.toString(r));

        int[] r2 = twoSum2(nums, 3);
        System.out.println(Arrays.toString(r2));

    }
}
