package com.vanjor.leetcode.t350;

import java.util.HashMap;

/**
 *  easy
 *  problem: intersection-of-two-arrays-ii https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *  time: 20 minute
 *  performance: O(n) time, O(n) space , >78% Java
 *  method: dic
 */
public class Solution implements SolutionInterface {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] baseNums = nums2.length > nums1.length ? nums1 : nums2;
        int[] loopNums = nums2.length > nums1.length ? nums2 : nums1;
        HashMap<Integer, Integer> dic = new HashMap<>();
        for (int value : baseNums) {
            if (dic.containsKey(value)) {
                dic.put(value, dic.get(value) + 1);
            } else {
                dic.put(value, 1);
            }
        }
        int[] tmpResult = new int[baseNums.length];
        int index = 0;
        for (int value : loopNums) {
            if (dic.containsKey(value) && dic.get(value) > 0) {
                tmpResult[index] = value;
                index++;
                dic.put(value, dic.get(value) - 1);
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = tmpResult[i];
        }
        return result;
    }
}