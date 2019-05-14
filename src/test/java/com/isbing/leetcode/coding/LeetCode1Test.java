package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by song bing
 * Created time 2019/5/14 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode1Test extends LeetCode1{

	@Test
	public void twoSumTest(){
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] ints = twoSum(nums, target);
		System.out.println(Arrays.toString(ints));
	}


	@Override
	public boolean isPalindrome(String s) {
		return false;
	}
}
