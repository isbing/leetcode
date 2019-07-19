---
title: LeetCode70-爬楼梯的方法
date: 2019-07-15
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2

输出： 2

解释： 有两种方法可以爬到楼顶。

1. 1 阶 + 1 阶
2. 2 阶

示例 2：

输入： 3

输出： 3

解释： 有三种方法可以爬到楼顶。

1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

## 分析

只有1层楼的时候，有一种方法

两阶楼的时候，两种方法（1+1 或者 2）

三阶楼的时候，三种方法（1+1+1 1+2 2+1）

这不就是斐波拉契数列么 f(n) = f(n-1) + f(n-2)

### 递归
f(n) = f(n-1) + f(n-2) n=1时 返回1 n=2时 返回2 否则 f(n) = f(n-1) + f(n-2)

Time: O(n), Space: O(1)

### 迭代
迭代也是这个公式

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode70Test {

	@Test
	public void tt(){
		System.out.println(climbStairs(4));
		System.out.println(climbStairsV2(4));
	}

	public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		return climbStairs(n-1)+climbStairs(n-2);
	}

	public int climbStairsV2(int n) {
		int first = 1;
		int second = 2;
		if(n == 1) return first;
		if(n == 2) return second;

		for(int i=3; i<=n; i++){
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
}


````









