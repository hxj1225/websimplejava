package com.hxj.websimplejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 */
public class HashMapTest {

    Map<Object, String> hashMap;

    {
        hashMap = new HashMap<Object, String>();
        hashMap.put("a", "a");
        hashMap.put("a", "aa");
        hashMap.put("a", "aaa");
        hashMap.put("a", "aaaa");
        hashMap.put("a", "aaaaa");
        hashMap.put("b", "b");
        hashMap.put("b", "bb");
        hashMap.put("c", "c");

        // Integer.valueOf(49).hashCode() == "1".hashCode() ·µ»Øtrue
        hashMap.put(Integer.valueOf(49), "Integer.valueOf(49)");
        hashMap.put("1", "1");
    }

    public static void test(String id) {
        if (!id.equals("1")) {
            throw new IllegalArgumentException("aaaa");
        }
    }

    public static void main(String[] args) {
        try {

            HashMapTest.test("2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMapTest hashMapTest = new HashMapTest();
        Map<Object, String> map = hashMapTest.hashMap;
        for (Entry<Object, String> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
        System.out.println(Integer.valueOf(49).hashCode() == "1".hashCode());
        System.out.println(0.1 * 0.2);
        System.out.println(-1 >>> 2);
        System.out.println(-1 >> 2);
    }

}
