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
public class LeetCode50Test {

	@Test
	public void test(){
		System.out.println(myPow(2,10));
	}

	public double myPow(double x, int n) {
		long N = Math.abs((long)n);
		double result = 1;
		while (N != 0){
			if((N & 1) == 1){
				result *= x;
			}
			x *= x;
			N = N >> 1;
		}
		return n<0?1/result:result;
	}
}
