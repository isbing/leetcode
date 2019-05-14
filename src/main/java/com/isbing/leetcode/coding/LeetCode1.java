package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/5/14 18:08
 */
public abstract class LeetCode1 extends LeetCoding {

	// 解法1 两层循环暴力 空间为O(1) 时间O(n方)
	// 解法2 用哈希表 空间为O(n) 时间O(n)

	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
	 * 并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * 示例:
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 *
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 */
	@Override
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length < 2) return new int[]{-1,-1};
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int one = nums[i];//第一个数
			int two = target - one;//需要的第二个数
			if(map.containsKey(two)){
				// 在map中找到 直接返回
				return new int[]{i,map.get(two)};
			}else{
				// 没有在map中找到 就将当前值放入
				map.put(one,i);
			}
		}
		return new int[]{-1,-1};
	}


}
