package com.hxj.websimplejava.algorithm;

/**
 * We have to maximize the Area that can be formed between the vertical lines using the shorter line as length and the
 * distance between the lines as the width of the rectangle forming the area.
 *
 * @author xiangjun.hexj
 * @date 2018/11/22 15:55
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) { l++; } else { r--; }
        }
        return maxarea;
    }
}
