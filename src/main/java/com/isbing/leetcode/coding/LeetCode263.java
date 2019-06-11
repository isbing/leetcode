package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by song bing
 * Created time 2019/6/11 14:52
 */
public abstract class LeetCode263 extends LeetCoding {

	// 能被2整除 就不断除以2，直到不能被2整除为止，看这个因数 为1，说明是 丑数
	// 除以3.。最后是5.。
	// Time: O(m+n+L), Space: O(1)  m个2 n个3 L个5


	/**
	 * 这个题目说的是，给你一个数字，你要判断它是不是一个丑数。
	 * 丑数的定义是质因数只包含 2，3，5 的正整数。另外，1 作为特例，也定义为丑数。
	 * 比如说给你的数字是 45，45 做质因数分解，可以写成：
	 * 45 = 3 x 3 x 5
	 * 不包含 2，3，5 以外的质因数，因此它是一个丑数。
	 * 再比如说 42，它做质因数分解得到：
	 * 42 = 2 x 3 x 7
	 * 7 不在 2，3，5 中，因此 42 不是丑数。
	 */
	@Override
	public boolean isUgly(int num) {
		if(num <= 0){
			return false;
		}
		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		if(num == 1)
			// 刚好整除
			return true;
		return false;
	}
}
