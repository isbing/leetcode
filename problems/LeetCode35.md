---
title: LeetCode35-二分搜索插入位置
date: 2019-07-19
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5

输出: 2

示例 2:

输入: [1,3,5,6], 2

输出: 1

示例 3:

输入: [1,3,5,6], 7

输出: 4

示例 4:

输入: [1,3,5,6], 0

输出: 0

## 分析
这个题目跟二分查找很相似，只不过是二分查找如果查找不到，返回的是-1，这里返回的是需要插入的位置

例如数组{-2,0,2,4,5,8,9} target=6

二分法来分析

1. 初始化low=0,high=6 此时low<=high
2. mid=3 a[mid]=4<target.那么low=mid+1=4 high=6 low<=high
3. mid=5 a[mid]=8>target.那么low=4 high=mid-1=4 low<=high
4. mid=4 a[mid]=5<target.那么low=mid+1=5 high=4 low>high结束循环
5. 然后画图发现，low=5的位置 就是需要插入的位置 直接返回low就行

Time: O(log(n)), Space: O(1)

## 解答

````java
import org.junit.Test;
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


````









