package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
