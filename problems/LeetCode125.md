---
title: LeetCode125-判断回文串
date: 2020-03-06
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

1. 判断回文串，就用一次循环，两个游标，分别比对字符是否相等即可
2. 题目要求 只考虑字母和数字字符。若发现其余的字符，跳过即可
3. 时间复杂度O(N) 空间复杂度为O(1)

## 总结
1. 学会使用前后指针来分析解决问题
2. char类型的大小比较是没有String中的equals()方法的
3. A的ascii码值是65，a的ascii码值是97，小写字母比大写字母的ascii值大32

## 解答

````java
import org.junit.Test;
public class LeetCode125 {
	@Test
	public void test(){
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public boolean isPalindrome(String s) {
		// 用两个游标指向字符串的头尾
		int i = 0, j = s.length()-1;
		while (i <= j){
			// 判断i,j是否是数字 或者是 字母
			if(!isNeed(s.charAt(i))){
				i++;
				continue;
			}
			if(!isNeed(s.charAt(j))){
				j--;
				continue;
			}
			// 判断两个字符 除去大小写的比较
			if(!isEqual(s.charAt(i),s.charAt(j))){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private boolean isNeed(char num) {
		if(num >= '0' && num <= '9'){
			return true;
		}
		if(num >= 'a' && num <= 'z'){
			return true;
		}
		if(num >= 'A' && num <= 'Z'){
			return true;
		}
		return false;
	}

	private boolean isEqual(char num1,char num2){
		// A -> 65; a->97  全部转换为小写字母比较
		if(num1 >= 'A' && num1 <= 'Z') num1 += 32;
		if(num2 >= 'A' && num2 <= 'Z') num2 += 32;
		return num1 == num2;
	}
}

````









