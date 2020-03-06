package com.isbing.leetcode.coding;

import org.junit.Test;

/**
 * Created by song bing
 * Created time 2020/3/6 10:32
 */
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
