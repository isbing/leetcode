---
title: LeetCode125-判断回文串
date: 2019-06-01
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

1. 题目要求 只考虑字母和数字字符。所以其他不合法的字符都可以看做不存在一样
2. 这里可以考虑 前后指针移动 前后指针指向的字符比较
3. 时间复杂度O(N) 空间复杂度为O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode125Test {

	@Test
	public void test(){
		String s = "race a car";
		System.out.println(isPalindrome(s));
	}

	public boolean isPalindrome(String s){
		if(s == null || s.length() == 0){
			return true;
		}
		// 定义初始状态 头尾指针
		int begin = 0;
		int end = s.length()-1;
		while (begin <= end){
			// 校验当前字符是否合法
			// 谁不合法 谁就移动一下
			if(!isNeed(s.charAt(begin))){
				begin++;
				continue;
			}
			if(!isNeed(s.charAt(end))){
				end--;
				continue;
			}
			// 不相等 就不是回文串
			if(!isEqual(s.charAt(begin),s.charAt(end))){
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}

	// 判断当前字符 是否合法
	public boolean isNeed(char c){
		if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
			return true;
		}
		return false;
	}

	// 判断两个字符是否相等 忽略大小写。。一律用小写比较
	public boolean isEqual(char first,char last){
		//如果输入的是大写，+32即可得到小写
		if(first >= 'A' && first <= 'Z') first += 32;
		if(last >= 'A' && last <= 'Z') last += 32;
		return first == last;
	}

}

````









