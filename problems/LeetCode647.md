---
title: LeetCode647-回文子串的个数
date: 2019-07-17
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"

输出: 3

解释: 三个回文子串: "a", "b", "c".

示例 2:

输入: "aaa"

输出: 6

说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

注意:

输入的字符串长度不会超过1000。

## 分析
### 暴力解
对于abc来说，两层for循环可以拿到一个任意的连续子串

如i=0 j=i+1,这样的s[i,j]就是一个字串，时间为O(N方)，然后判断这个子串是否是回文串，时间为O(N)

如果是，count++即可。时间O(N三次方) 空间O(1)

### 动态规划
动态规划的思想：就是原问题的解依靠于子问题的解。

采用dp[i][j]二维数组来表示字串s[i,j]是否是回文串。

对于s[i,j]来说

1. 假如 charAt(i) == charAt(j),直接dp[i,j]=true
2. 如果 i与j相邻（i+1==j），那么需要当charAt(i) == charAt(j),也是dp[i,j]=true
3. 否则（意思是 i，j相距至少两个位置） dp[i,j]=charAt(i) == charAt(j)&&dp[i+1][j-1]

因为是在遍历的同时，给这个s[i,j]子串打标，那么得知道dp[i+1][j-1]的情况，就需要先遍历到。i就从大开始

空间 时间都是 O(N方)

### 优化解法
aba来说，采用针对指定子串，左右扩展的思路

一次循环遍历字符串，对于遍历到的每个字符，采用中心扩展比较

1. 对于a来说，是回文子串 count++，左右扩展 左边越界，开始下次循环
2. 对于b，是回文子串 count++，左右扩展 a==a，那么也是回文字串 count再++
3. 对于a，是回文字串 count++，左右扩展 右边越界 开始下次循环
4. 结束循环

奇数的情况，中心数字就一个，左右扩展能刚好分完

这是奇数的情况，有一种特殊情况 得处理这个情况，那就是偶数，并且中心是两个数字的情况

比如 abba
1. a扩展，count++
2. b扩展，count++
3. b扩展，count++
4. a扩展，count++

> 但是结果是错误的，因为是偶数，得用两个中心数字去扩展 i = b,j=i+1 去扩展。

这样中心数字左右扩展的时候 才能刚好分配完。

1. 用左右相等数字去扩展
2. 用左右相邻数字再去扩展
3. 结果相加即可。。出现第二步 就是为了去包容那个特殊情况，否则会遗漏情况

时间O(N方) 空间O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode647Test {

	// 时间：O(N方)  空间：O(N方)  动态规划
	public int countSubstrings_1(String s) {
		if(s == null || s.length() == 0) return 0;
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		int count = 0;
		for(int i=n-1; i>=0; i--){
			for(int j=i; j<n; j++){
				if(i == j){
					dp[i][j] = true;
				}else if(i+1 == j){
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}else{
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
				}

				if(dp[i][j]){
					count++;
				}
			}
		}
		return count;
	}

	// 时间：O(N方)  空间：O(1)  中心扩展
	public int countSubstrings_2(String s) {
		if(s == null || s.length() == 0) return 0;
		int count = 0;
		for(int i=0; i<s.length(); i++){
			count += expand(s,i,i);
			count += expand(s,i,i+1);
		}
		return count;
	}

	private int expand(String s, int left, int right) {
		int count = 0;
		while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
			count++;
		}
		return count;
	}
}


````









