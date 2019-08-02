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
public class LeetCode191Test {

	@Test
	public void test(){
		System.out.println(hammingWeight(12));
	}

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0){
			count++;
			n = n & (n-1);
		}
		return count;
	}
}
