---
title: LeetCode125-判断回文串
date: 2019-06-01 20:00:00
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"

输出: true

示例 2:

输入: "race a car"

输出: false

## 分析

本题很简单，分析略

## 解答

````java
import org.junit.Test;
public class _001TwoSum {
	
	@Test
	public void test() {
		int[] nums= {3,2,4};
		System.out.println(Arrays.toString(twoSum(nums, 6)));
	}
	
	
    public int[] twoSum(int[] nums, int target) {
       for (int i = 0; i < nums.length; i++) {
		int temp=target-nums[i];
		for (int j = i+1; j < nums.length; j++) {
			if (temp==nums[j]) {
				 int[] result={i,j};
				return result;
			}
		}
	}
       return new int[] {0,0};
    }
}
````









