package com.isbing.leetcode.coding;

/**
 * Created by song bing
 * Created time 2020/3/10 16:54
 */
public class LeetCode704 {

	// 二分查找 迭代法 直接都能默写出来的基础算法
	public int search_1(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while (low <= high){
			int mid = high - (high-low)/2;
			if(nums[mid] > target){
				high = mid - 1;
			}else if(nums[mid] < target){
				low = low + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	// 二分查找 递归法 直接都能默写出来的基础算法
	public int search_2(int[] nums, int target) {
		return search_2_di(nums,target,0,nums.length-1);
	}

	private int search_2_di(int[] nums, int target, int low, int high) {
		if(low > high) return -1;
		int mid = high - (high-low)/2;
		if(nums[mid] > target){
			high = mid - 1;
			return search_2_di(nums,target,low,high);
		}else if(nums[mid] < target){
			low = low + 1;
			return search_2_di(nums,target,low,high);
		}else{
			return mid;
		}
	}

}
