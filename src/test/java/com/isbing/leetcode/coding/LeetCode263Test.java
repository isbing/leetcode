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
