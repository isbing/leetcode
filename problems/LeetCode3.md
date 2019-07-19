---
title: LeetCode3-无重复字符的最长子串
date: 2019-07-14
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2:
```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例 3:
```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

## 分析

### 暴力解
这个题目最原始的想法 就是两次循环，例如 abcabcbb
1. 初始化最大子串长度为0，内外两次循环
2. i指向a j指向b，j每次走到一个位置时 都要判断是否在子串中 j是否在[i,j)串中
3. 两层循环 时间为0(N方)，但是j中指向的字符 每次需要判断是否出现在子串中 0(N)

所以  时间为 O(N的三次方) 空间为O(1)

### 优化解
采用滑动窗口的思想。j在遍历过程中出现相同字符，不会使得i,j重新开始

只是会将i调整位置，但是j还是会从当前位置出发 滑动窗口

采用map记录一下每个字符出现的位置

abcabcbb

1. i首先指向a，j指向a map中 a:0
2. j指向b，b不在map中，添加到map。a:0;b:1。。同时maxLength能更新就更新
3. j指向c，c不在map中，添加到map。a:0;b:1;c:2。。同时maxLength能更新就更新
4. j指向a，发现在map中。【i就得指向后一位】，但是j还是从当前位置走。只会遍历一次

> 经过测试 【i就得指向后一位】这个想法还有点问题

abcbd例如 此时i重新指向b之后，下一次循环j指向了d，子串为bcbd了.

所以i的重新指向位置  为当前重复节点出现的位置+1

map中查找是否存在，O(1)

所以  时间为 O(N) 空间为O(M)


## 解答

````java
import org.junit.Test;
public class LeetCode3Test {

	@Test
	public void tt(){
		System.out.println(lengthOfLongestSubstring("aa"));
		System.out.println(lengthOfLongestSubstringV2("tmmzuxt"));
	}

	// 时间O(N的三次方) 空间O(1) 大暴力解法
	public int lengthOfLongestSubstring(String s) {
		// abcabcbb
		int length = s.length();// O(N)
		if(length == 0) return 0;

		int maxLength = 1;
		for(int i=0; i<length; i++){
			for(int j=i+1; j<length; j++){
				// j不在[i,j)串中
				String substring = s.substring(i, j);// [i,j)
				if(substring.contains(s.charAt(j)+"")){
					// 结束内层循环
					break;
				}else{
					int len = j-i+1;
					if(len > maxLength){
						maxLength = len;
					}
				}
			}
		}
		return maxLength;
	}


	// 时间O(N) 空间O(M) 优化解法
	public int lengthOfLongestSubstringV2(String s) {
		// abcabcbb
		int length = s.length();// O(N)
		if(length == 0) return 0;
		HashMap<Character,Integer> map = new HashMap<>();

		int maxLength = 1;
		for(int i=0,j=0; j<length; j++){
			if(map.containsKey(s.charAt(j))){
				// j在map里面 i从出现重复数字位置的后一位开始
				i = Math.max(map.get(s.charAt(j))+1,i);
			}
			map.put(s.charAt(j),j);
			int len = j-i+1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		return maxLength;
	}
}


````









