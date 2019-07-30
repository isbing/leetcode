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
public class LeetCode704Test {

	@Test
	public void tt(){
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search_1(nums,9));
		System.out.println(search_2(nums,9));
	}

	// 非递归
	public int search_1(int[] nums, int target) {
		if(nums == null) return -1;
		int low = 0;
		int high = nums.length-1;

		while (low <= high){
			int mid = low + (high-low)/2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return -1;
	}


	// 递归
	public int search_2(int[] nums, int target) {
		if(nums == null) return -1;
		int low = 0;
		int high = nums.length-1;
		return diGui(nums,target,low,high);
	}

	private int diGui(int[] nums, int target, int low, int high) {
		// 递归的结束条件
		if(low > high){
			return -1;
		}
		int mid = low + (high - low) / 2;
		if(nums[mid] == target){
			return mid;
		}else if(nums[mid] < target){
			return diGui(nums,target,mid+1,high);
		}else{
			return diGui(nums,target,low,mid-1);
		}
	}
}
