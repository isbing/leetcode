---
title: LeetCode50-数值的N次方
date: 2019-07-18
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10

输出: 1024.00000

示例 2:

输入: 2.10000, 3

输出: 9.26100

示例 3:

输入: 2.00000, -2

输出: 0.25000

解释: 2-2 = 1/22 = 1/4 = 0.25

## 分析

### 暴力解
简单暴力的方法就是 将数字连续乘以 n 次，即可

Time: O(n), Space: O(1)

### 优化解
可以采用一种思路 例如 2的11次方

11的二进制为 1101 

1248

1101

- 1+2+8=11

分析为 2^11 = 2^1 * 2^2 * 2^8

(N & 1) 取二进制的第一位

N = N >> 1;向右移动一位，数字就相当于 /2.

所以 Time: O(log(n)), Space: O(1)
## 解答

````java
import org.junit.Test;
public class LeetCode50Test {

	@Test
	public void test(){
		System.out.println(myPow(2,10));
	}

	public double myPow(double x, int n) {
		long N = Math.abs((long)n);
		double result = 1;
		while (N != 0){
			if((N & 1) == 1){
				result *= x;
			}
			x *= x;
			N = N >> 1;
		}
		return n<0?1/result:result;
	}
}

````









