package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by song bing
 * Created time 2019/5/14 17:23
 */
public abstract class LeetCode125 extends LeetCoding {

	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * 说明：本题中，我们将空字符串定义为有效的回文串。
	 * 示例 1:
	 * 输入: "A man, a plan, a canal: Panama"
	 * 输出: true
	 * 示例 2:
	 * 输入: "race a car"
	 * 输出: false
	 */
	@Override
	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0){
			return true;
		}
		int j = s.length()-1;
		for(int i=0; i<=j; ){
			// 判断i只能为数字或者字符串
			char first = s.charAt(i);
			if(!isNeed(first)){
				i++;
				continue;
			}
			char last = s.charAt(j);
			if(!isNeed(last)){
				j--;
				continue;
			}
			if(!isEqual(first,last)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * 只保留字母数字
	 * @param c
	 * @return
	 */
	private boolean isNeed(char c){
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
	}

	/**
	 * 全部用小写进行比较
	 * @param first
	 * @param last
	 * @return
	 */
	public boolean isEqual(char first,char last){
		//如果输入的是大写，+32即可得到小写
		if(first >= 'A' && first <= 'Z') first += 32;
		if(last >= 'A' && last <= 'Z') last += 32;
		return first == last;
	}

}
