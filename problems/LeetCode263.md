---
title: LeetCode263-丑数
date: 2019-07-11
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例 1:

输入: 6

输出: true

解释: 6 = 2 × 3

示例 2:

输入: 8

输出: true

解释: 8 = 2 × 2 × 2

示例 3:

输入: 14

输出: false 

解释: 14 不是丑数，因为它包含了另外一个质因数 7。

说明：

1 是丑数。

输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。

## 分析

审题，丑数的定义为：只包含质因数 2, 3, 5 的正整数。同时1也是整数

那么我们就可以针对一个数字，先用2一直除，当不能被2整除的时候

再用3一直除，直到也不能再被3整除了

最后用5一直除，直到也不能被5整除了，若此时结果为1，就是丑数

Time: O(m+n+L), Space: O(1)  m个2 n个3 L个5

## 解答

````java
import org.junit.Test;
public class LeetCode263Test {

	@Test
	public void tt(){
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
	}

	public boolean isUgly(int num) {
		if(num <= 0){
			return false;
		}
		// 能被2整除
		while (num % 2 == 0){
			num = num / 2;
		}
		// 能被3整除
		while (num % 3 == 0){
			num = num / 3;
		}
		// 能被5整除
		while (num % 5 == 0){
			num = num / 5;
		}
		return num == 1;
	}
}


````









