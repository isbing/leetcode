---
title: LeetCode167-有序数组的两数之和
date: 2019-06-02
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素

示例:

输入: numbers = [2, 7, 11, 15], target = 9

输出: [1,2]

解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。


## 分析
划重点！！！有序数组是重点

可不可以用hash表，用暴力解法呢？当然可以，能做出来就是最棒的。

但是分析可以发现，使用哈希表空间复杂度是O(N)

这里因为有序数组，可以明显的发现，如果用前后指针逼近，是无须额外的空间存储的

int[] nums = {2, 7, 11, 15}; int target = 9;

首指针2，尾指针15。2+15=17 > 9。这里只需要尾指针向前移动，因为是大数大了，需要将大数调小一点

时间为0(N) 空间为O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode167Test {

	@Test
	public void test(){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}

	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2){
			return new int[]{-1,-1};
		}
		int begin = 0;
		int end = numbers.length - 1;
		while (begin <= end){
			if(numbers[begin] + numbers[end] == target){
				return new int[]{begin+1,end+1};
			}else if(numbers[begin] + numbers[end] > target){
				// 大数大了，整体需要调小
				end--;
			}else{
				begin++;
			}
		}
		return new int[]{-1,-1};
	}
	
}


````









