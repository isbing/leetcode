package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode384Test {

	private Random random = new Random();

	public int[] shuffle(int[] nums) {
		for(int i=nums.length-1; i>=0 ; i--){
			int j = random.nextInt(i + 1);
			swap(nums,i,j);
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	@Test
	public void tt(){
		System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,5})));
	}
}
