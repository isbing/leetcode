package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by song bing
 * Created time 2019/5/14 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode125Test extends LeetCode125{

	@Test
	public void test1(){
		boolean hah = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(hah);
	}

	@Test
	public void test2(){
		boolean hah = isPalindrome("race a car");
		System.out.println(hah);
	}

	@Override
	public int[] twoSum(int[] nums, int target) {
		return new int[0];
	}
}
