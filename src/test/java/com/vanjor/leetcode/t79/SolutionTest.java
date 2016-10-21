package com.vanjor.leetcode.t79;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSolution(){
        SolutionInterface solution = new Solution();
        testSolution(solution);
    }

    public void testSolution(SolutionInterface solution){
        char [][] case1 =  {{'a','b','c'},{'d','e','f'},{'g','h','k'}};
        Assert.assertFalse(solution.exist(case1,"123"));
        Assert.assertFalse(solution.exist(case1,"abcd"));
        Assert.assertTrue(solution.exist(case1,"abcfeh"));

        char [][] case2 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        Assert.assertTrue(solution.exist(case2,"ABCESEEEFS"));

        char [][] case3 = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        Assert.assertTrue(solution.exist(case3,"AAB"));
    }

}
