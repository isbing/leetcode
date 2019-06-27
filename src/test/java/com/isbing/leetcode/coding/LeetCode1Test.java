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
public class LeetCode1Test {

	@Test
	public void test(){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSumBao(nums,target)));
	}

	public int[] twoSumBao(int[] nums, int target) {
		if(nums == null || nums.length < 2){
			return new int[]{0,0};
		}
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					return new int[]{i,j};
				}
			}
		}
		return new int[]{0,0};
	}

	public int[] twoSumYou(int[] nums, int target) {
		if(nums == null || nums.length < 2){
			return new int[]{0,0};
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int otherValue = target - nums[i];
			if(map.containsKey(otherValue)){
				return new int[]{map.get(otherValue),i};
			}else{
				map.put(nums[i],i);
			}
		}
		return new int[]{0,0};
	}
}
