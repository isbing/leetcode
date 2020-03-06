package com.isbing.leetcode.coding;

import org.junit.Test;

/**
 * Created by song bing
 * Created time 2020/3/6 15:00
 */
public class LeetCode136 {

	@Test
	public void test(){
		System.out.println(singleNumber(new int[]{2,2,1}));
	}

	public int singleNumber(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result = result ^ nums[i];
		}
		return result;
	}

}
