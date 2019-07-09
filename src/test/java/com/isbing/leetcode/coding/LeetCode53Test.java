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
public class LeetCode53Test {

	@Test
	public void test(){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;

		for(int i=0; i<nums.length; i++){
			if(sum <= 0){
				// 一连串的和为0或者负数 说明对当前子序列没啥正向影响 重新从下一个数字开始
				sum = nums[i];
			}else{ // 有正向的影响 就相加
				sum = sum + nums[i];
			}
			// 每一次 index都要与max比较一下 随时替换最大值
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}
}
