package com.isbing.leetcode.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by song bing
 * Created time 2020/3/6 11:05
 */
public class LeetCode1 {
	@Test
	public void test(){
		System.out.println(Arrays.toString(twoSum_1(new int[]{2,7,11,15},9)));
		System.out.println(Arrays.toString(twoSum_2(new int[]{2,7,11,15},9)));
	}

	// 暴力解法 直接两层循环 搞定
	public int[] twoSum_1(int[] nums, int target) {
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}

	// 优化解法，典型的空间换时间 key为num，value为index
	public int[] twoSum_2(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int one = nums[i];
			int two = target - one;
			// 查看第二个值 是否在map中，如果在 就最好了，如果不在 将当前值以及角标放入map中
			if(map.containsKey(two)){
				return new int[]{map.get(two),i};
			}else{
				map.put(one,i);
			}
		}
		return new int[]{-1,-1};
	}
}
