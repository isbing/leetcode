---
title: LeetCode9-回文数
date: 2019-07-05
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121

输出: true

示例 2:

输入: -121

输出: false

解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:

输入: 10

输出: false

解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:

你能不将整数转为字符串来解决这个问题吗？

## 分析
解法1：

思路很简单，将这个整数转换为字符串，然后前后指针指向，依次比较

Time: O(N), Space: O(1)

解法2：

不使用字符串的话，可以考虑构造。

例如数字123，我们构造一个数字 321.与之比较就完事了。前提是大于0的数字

123是从左向右构造的，现在需要构造一个 从右到左的数字

构造公式可以采用 y = y * 10 + num 来搞。例如123

1. 首先y=0, 0*10+3 = 3
2. y = 3了，再用2，3*10+2=32
3. y = 32了，再用1，32*10+1=321

Time: O(N), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode9Test {

	@Test
	public void tt(){
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
	}

	public boolean isPalindromeV2(int x) {
		// 123
		if(x < 0) return false;
		int temp = x;
		int y = 0;
		while (temp != 0){
			// 取最后一位数字
			int num = temp % 10;
			y = y * 10 + num;
			temp = temp / 10;
		}
		return x == y;
	}

	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		// 定义前后指针的位置
		int head = 0;
		int tail = s.length()-1;
		while (head <= tail){
			if(s.charAt(head) != s.charAt(tail)){
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}
}


````









