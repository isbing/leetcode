---
title: LeetCode53-最大连续子序和
date: 2019-07-07
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],

输出: 6

解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

## 分析
### 暴力解
最外面记录一个最大值，两层for循环。穷举所有的连续子序列 并求和进行对比。只要大的就替换原有的最大值

两层for循环 O(N方)。时间复杂度至少O(N方)

### O(N)解法
[2 -8 3 -2 4 -10 2 3 4 5 6]

2-8 = -6 只要是负数 就对子序列的和 没有任何贡献 还不如从 3 重新出发。

3-2=1 1<max max不变

1+4=5 5>max max变跟为5.5-10 = -5 负数 就舍弃

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode53Test {

	@Test
	public void test(){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;

		for(int i=0; i<nums.length; i++){
			if(sum <= 0){
				// 一连串的和为0或者负数 说明对当前子序列没啥正向影响 重新从下一个数字开始
				sum = nums[i];
			}else{ // 有正向的影响 就相加
				sum = sum + nums[i];
			}
			// 每一次 index都要与max比较一下 随时替换最大值
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}
}


````









