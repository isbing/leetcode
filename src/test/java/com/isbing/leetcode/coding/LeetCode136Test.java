package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode136Test {

	@Test
	public void test(){
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber2(nums));
		System.out.println(singleNumber3(nums));
	}

	// 暴力略
	public int singleNumber1(int[] nums) {
		return -1;
	}

	// 时间O(N) 空间O(N)
	public int singleNumber2(int[] nums) {
		if(nums == null){
			return -1;
		}
		Set<Integer> set = new HashSet<>();
		int originSum = 0;
		int setSum = 0;
		for(int i=0; i<nums.length; i++){
			// 循环的过程中 将set填充 将和算出来
			originSum += nums[i];
			boolean flag = set.add(nums[i]);
			if(flag){ // 添加成功
				setSum += nums[i];
			}
		}
		return setSum * 2 - originSum;
	}

	// 时间O(N) 空间O(1)
	public int singleNumber3(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}
}
