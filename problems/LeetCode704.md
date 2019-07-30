---
title: LeetCode704-二分查找
date: 2019-07-17
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9

输出: 4

解释: 9 出现在 nums 中并且下标为 4

示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2

输出: -1

解释: 2 不存在 nums 中因此返回 -1


## 分析
二分查找 有递归 非递归两种实现方法

因为给定数组是排序好的，所以给定low=0 high=length-1

每次用mid与目标值target比较 然后再根据大小 固定low high的位置

算mid时 尽量不要用 (low+high)/2。防止越界。可以使用 low + (high-low)/2

Time: O(log(n)), Space: O(1)

## 解答

````java
import org.junit.Test;
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


````









