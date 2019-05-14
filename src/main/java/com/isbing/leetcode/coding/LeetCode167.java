package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by song bing
 * Created time 2019/5/14 18:41
 */
public abstract class LeetCode167 extends LeetCoding {

	// 题目要求有序数组。所以最优解就是 左右两个下标移动。时间为0(N) 空间为O(1)

	/**
	 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
	 * 说明:
	 * 返回的下标值（index1 和 index2）不是从零开始的。
	 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	 * 示例:
	 * 输入: numbers = [2, 7, 11, 15], target = 9
	 * 输出: [1,2]
	 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
	 */
	@Override
	public int[] twoSumV2(int[] numbers, int target) {
		// 2 7 11 15
		// 左右两个下标 2+15 > 9 就说明 右边的直接向前移动。。
		if(numbers == null || numbers.length < 2) return new int[]{-1,-1};
		int right = numbers.length-1;
		for(int left=0; left<=right; ){
			if(numbers[left] + numbers[right] < target){
				left++;
			}else if(numbers[left] + numbers[right] > target){
				right--;
			}else{
				return new int[]{left+1,right+1};
			}
		}
		return new int[]{-1,-1};
	}
}
