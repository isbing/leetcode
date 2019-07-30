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
