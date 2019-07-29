---
title: LeetCode5-最长回文子串
date: 2019-07-16
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"

输出: "bab"

注意: "aba" 也是一个有效答案。

示例 2：

输入: "cbbd"

输出: "bb"



## 分析

这个题目的更新耽搁了很久，主要是在研究动态规划这种思路。。。

### 暴力解
1. 两层for循环可以得到任意一个子串 O(N方)
2. 在循环里面判断这个子串是否是回文 O(N)
3. 在求解的过程中，保存最大长度的回文串即可

Time: O(n^3), Space: O(1)

### 动态规划
上面的暴力解法 是两层普通的for循环遍历，最后再判断 s[i,j]是否是回文子串，又是一个O（N）

那么我们可不可以将判断是否是回文子串的时候 进一步优化呢？

可以的！采用动态规划的思想，遍历的时候 对于i,j组成的子序列进行打标。dp[n][n]

对于s[i,j]来说

1. 假如 charAt(i) == charAt(j),直接dp[i,j]=true
2. 如果 i与j相邻，那么需要当charAt(i) == charAt(j),也是dp[i,j]=true
3. 否则（意思是 i，j相距至少两个位置） dp[i,j]=charAt(i) == charAt(j)&&dp[i+1][j-1]

> 第三点解释：首尾对应的字符一样，同时里面的子序列也要是回文串。

要点就来了，因为要判断dp[i+1][j-1]。那么i需要从最大开始遍历，不然的话 我这个时候的判断 dp[i+1][j-1]都还没有赋值呢！


动态规划将时间复杂度缩短为O(N方)，但是使用了二维数组 Space: O(n^2)

### 优化解
abcbab 奇数个数字的时候 分析一波

1. 对于a来说，a向左右扩散 发现没有合适的 最大子串为a
2. 对于b来说，b向左右扩散为abc 不是回文 最大子串为b
3. 对于c来说，c向左右扩散 成为bcb是回文，再次扩散为abcba是回文，再次扩散，不是，最大为abcba
4. 依次每个数字 这样左右扩散 即可

> 这里有个问题 就是 这是奇数个的时候，若为偶数的时候，i，j初始化时是相邻的位置 并且相等 然后扩散

所以用i,j去扩散的时候，要用两种方式都去扩散，然后看哪种方式的效果更好

Time: O(n^2), Space: O(1)


## 解答

````java
import org.junit.Test;
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


````









