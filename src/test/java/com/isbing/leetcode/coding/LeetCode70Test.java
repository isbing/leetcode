package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode70Test {

	@Test
	public void tt(){
		System.out.println(climbStairs(4));
		System.out.println(climbStairsV2(4));

	}

	public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		return climbStairs(n-1)+climbStairs(n-2);
	}

	public int climbStairsV2(int n) {
		int first = 1;
		int second = 2;
		if(n == 1) return first;
		if(n == 2) return second;

		for(int i=3; i<=n; i++){
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
}
