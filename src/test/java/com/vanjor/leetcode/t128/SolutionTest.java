package com.vanjor.leetcode.t128;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSolution(){
        SolutionInterface solution = new Solution();
        testSolution(solution);
    }

    @Test
    public void testSolution1(){
        SolutionInterface solution = new Solution1();
        testSolution(solution);
    }

    public void testSolution(SolutionInterface solution){
        int[] case1= {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4,solution.longestConsecutive(case1));
    }

}
