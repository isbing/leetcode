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
public class LeetCode268Test {

	@Test
	public void test(){
		System.out.println(missingNumber(new int[]{0,1,2,4}));
	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		int result = n;
		for(int i=0; i<n; i++){
			result = result ^ i ^ nums[i];
		}
		return result;
	}
}
