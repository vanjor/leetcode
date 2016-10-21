package com.vanjor.leetcode.t128;

import java.util.HashSet;

/**
 * by reading other code, simply version of my Solution
 */
public class Solution1 implements SolutionInterface {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for(int value:set){
            if(!set.contains(value-1)&&set.contains(value+1)){
                int nextValue = value+1;
                while(set.contains(nextValue)){
                    nextValue ++;
                }
                max = Math.max(max,nextValue-value);
            }
        }
        return max;
    }
}
