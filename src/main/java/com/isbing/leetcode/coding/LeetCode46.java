package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by song bing
 * Created time 2019/5/16 14:22
 */
public abstract class LeetCode46 extends LeetCoding {

	// 递归思路：先把第一个数字1固定下来。让剩下的2 3进行全排列。剩下的开启循环后 将2固定下来
	// 		3进行全排列 3只有一个数字 就打印123 此时固定的是2 回缩到上一版本23的时候 就要开始固定3 打印132
	// 		这个时候 固定的1 就结束了 恢复到原始状态 开始固定2。。2全部打印完了 恢复初始状态 再开始固定3
	// Time: O(n*n!), Space: O(n)

	/**
	 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
	 * 示例:
	 * 输入: [1,2,3]
	 * 输出:
	 * [
	 *   [1,2,3],
	 *   [1,3,2],
	 *   [2,1,3],
	 *   [2,3,1],
	 *   [3,1,2],
	 *   [3,2,1]
	 * ]
	 */
	@Override
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null)
			return null;
		List<Integer> numbers = new ArrayList<>();
		for(int num : nums)
			numbers.add(num);

		List<List<Integer>> result = new ArrayList<>();
		diGui(numbers,0,result);
		return result;
	}

	private void diGui(List<Integer> numbers, int start, List<List<Integer>> result) {
		// start 是固定的数字 1 2 3
		// start当与numbers的size等时，说明已经固定到最下一层了。要开始
		if(start == numbers.size()){
			// print numbers 就是 一个全排列的情况
			ArrayList<Integer> temp = new ArrayList<>(numbers);
			if(!result.contains(temp)){
				result.add(temp);
			}
		}
		for(int i=start; i<numbers.size(); i++){
			Collections.swap(numbers,i,start);
			diGui(numbers,start+1,result);
			Collections.swap(numbers,i,start);
		}
	}
}
