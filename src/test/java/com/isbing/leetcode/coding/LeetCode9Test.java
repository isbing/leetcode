package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
