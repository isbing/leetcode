package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
