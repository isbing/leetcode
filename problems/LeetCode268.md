---
title: LeetCode268-缺失的数字
date: 2019-07-22
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]

输出: 2

示例 2:

输入: [9,6,4,2,3,5,7,0,1]

输出: 8

说明:

你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

## 分析

### 最优解
这道题有点特别

假如给定数组为 [0,1,2,4]

但是原数组为 [0,1,2,3,4].那么需要返回3

对于从0遍历到数组最后来说 出现的数字是 0 1 2 3

对于原来的数组遍历出来的数字是 0 1 2 4

然后再来一个元素（数组的长度为4）

将这三个全部抑或，就得到了一个值 就是缺失的数字

因为  x^x=0 ...相同的数字抑或为0  0^x=x

Time: O(n), Space: O(1)
## 解答

````java
import org.junit.Test;
public class LeetCode268Test {

	@Test
	public void test(){
		System.out.println(missingNumber(new int[]{0,1,2,4}));
	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		int result = n;
		for(int i=0; i<n; i++){
			result = result ^ i ^ nums[i];
		}
		return result;
	}
}

````









