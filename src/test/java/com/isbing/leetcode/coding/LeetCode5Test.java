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
public class LeetCode5Test {

	@Test
	public void tt(){
		System.out.println(longestPalindrome_1("abcbab"));
        System.out.println(longestPalindrome_2("abcbab"));
        System.out.println(longestPalindrome_3("abcbab"));

    }

	// Time: O(n^3), Space: O(1)
	public String longestPalindrome_1(String s) {
		if(s == null || s.length() == 0) return "";
		String maxSubString = s.charAt(0)+"";
		for(int i=0; i<s.length(); i++){
			for(int j=i+1; j<s.length(); j++){
				// s[i,j] -- 含头不含尾
				String subString = s.substring(i,j+1);
				// 判断任意子串是否是回文串
				if(isHuiwen(subString)){
					if(subString.length() >= maxSubString.length()){
						maxSubString = subString;
					}
				}
			}
		}
		return maxSubString;
	}




    // Time: O(n^2), Space: O(n^2)
    public String longestPalindrome_2(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                // 遍历的同时进行打标
                if(i == j){
                    dp[i][j] = true;
                }else if(i+1 == j){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
                }
            }
        }
        int maxLength = 0;
        int start = 0;
        // 此时dp[][]记录着符合条件的所有数据
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(!dp[i][j]){
                    continue;
                }
                if(j-i+1 > maxLength){
                    maxLength = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }




    // Time: O(n^2), Space: O(1)
	public String longestPalindrome_3(String s) {
		if(s == null || s.length() == 0) return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            // 扩展的时候 用i==j去扩展
            int len1 = expand(s, i, i);
            // 扩展的时候 用i==j+1去扩展
            int len2 = expand(s, i, i+1);
            // 最后决定哪种指针组合 扩展效果更好
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len-1)/2;
                maxLen = len;
            }
        }
        return s.substring(start, start+maxLen);
	}

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }
        // (right-1) - (left+1) + 1
        return right - left - 1;
    }


    private boolean isHuiwen(String subString) {
		// 判断一个字符串是否回文，前后指针
		int start = 0;
		int end = subString.length()-1;
		while (start <= end){
			if(subString.charAt(start) != subString.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
