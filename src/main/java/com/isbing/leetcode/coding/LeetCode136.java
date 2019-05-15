package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by song bing
 * Created time 2019/5/15 14:24
 */
public abstract class LeetCode136 extends LeetCoding {

	// 思路一：因为题目特性 某个单一元素只出现一次。别的都是两次。set去重之后 相加乘以2 - 原数据和
	//         得到的结果就是那个单一出现的数字。时间O(N) 空间O(N)
	// 思路二：用抑或运算。抑或满足交换律。两个相同的数字抑或为0  0与一个数抑或 是其本身 时间O(N) 空间O(1)
	// x ^ x = 0   0^y = y   对于二进制来说 相同为0 不同为1

	/**
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	 * 说明：
	 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	 * 示例 1:
	 * 输入: [2,2,1]
	 * 输出: 1
	 * 示例 2:
	 * 输入: [4,1,2,1,2]
	 * 输出: 4
	 */
	@Override
	public int singleNumber(int[] nums) {
		return 0;
	}

	public int solution1(int[] nums) {
		if(nums == null) return -1;
		Set<Integer> set = new HashSet<>();
		int result = 0;
		int now = 0;
		for(int i=0; i<nums.length; i++){
			result += nums[i];
			set.add(nums[i]);
		}
		for(int num : set){
			now += num;
		}
		now = now * 2;//需要乘以2
		return now - result;
	}

	public int solution2(int[] nums) {
		int result = 0;
		for(int num : nums){
			result = result ^ num;
		}
		return result;
	}
}
