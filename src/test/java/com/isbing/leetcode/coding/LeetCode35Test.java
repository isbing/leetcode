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
public class LeetCode35Test {

	@Test
	public void test(){
		int[] nums = {-2, 0,2,4,5,8,9};
		int target = 6;
		System.out.println(searchInsert(nums,target));
	}

	public int searchInsert(int[] nums, int target) {
		if(nums == null) return -1;
		int low = 0;
		int high = nums.length-1;
		while (low <= high){
			int mid = low + (high-low)/2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return low;
	}
}
