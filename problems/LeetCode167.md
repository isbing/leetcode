---
title: LeetCode167-有序数组的两数之和
date: 2020-03-06
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

## 总结
1. 前面做过普通数组两数之和，现在这个题目多了一个有序
2. 增加了有序这个特征，我们就可以用前后两个指针逼近的方式，不用额外空间

## 解答

````java
import org.junit.Test;
public class LeetCode167 {

	@Test
	public void test(){
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
	}

	// 最优解法
	public int[] twoSum(int[] numbers, int target) {
		int i = 0,j = numbers.length-1;
		while (i < j){
			if(numbers[i] + numbers[j] < target){
				i++;
			}else if(numbers[i] + numbers[j] > target){
				j--;
			}else{
				return new int[]{i+1,j+1};
			}
		}
		return new int[]{-1,-1};
	}
}


````









