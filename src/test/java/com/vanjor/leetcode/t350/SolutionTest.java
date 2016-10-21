package com.vanjor.leetcode.t350;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        SolutionInterface solution = new Solution();
        testSolution(solution);
    }

    public void testSolution(SolutionInterface solution) {
        int[] case11 = {12, 2, 2, 0, 2, 2};
        int[] case12 = {9, 2, 2, 2, 0};
        int[] expect = {2, 2, 0, 2};
        System.out.println(Arrays.toString(solution.intersect(case11, case12)));
        System.out.println(Arrays.toString(expect));
        Assert.assertArrayEquals(expect, solution.intersect(case11, case12));
    }

}
