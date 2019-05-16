package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/5/16 11:08
 */
public abstract class LeetCode240 extends LeetCoding {

	// 因为矩阵特殊性 从最右上角的数字 开始移动
	// 当前比较值 比 中间值 大，就会比你这一行的数据都大，行数+1
	// 当前比较值 比 中间值 小，就会比这一列的所有数据都小，列数-1
	// 时间O(M+N) 空间O(1) 所有数据都比较一遍

	/**
	 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
	 * 每行的元素从左到右升序排列。
	 * 每列的元素从上到下升序排列。
	 * 示例:
	 * 现有矩阵 matrix 如下：
	 * [
	 *   [1,   4,  7, 11, 15],
	 *   [2,   5,  8, 12, 19],
	 *   [3,   6,  9, 16, 22],
	 *   [10, 13, 14, 17, 24],
	 *   [18, 21, 23, 26, 30]
	 * ]
	 * 给定 target = 5，返回 true。找到后返回它的下标 [1, 1] 即可。
	 * 给定 target = 20，返回 false。
	 */
	@Override
	public boolean searchMatrix(int[][] matrix, int target) {
		// 当前值 比 中间点 小  列数-1
		// 当前值 比 中间点 大  行数+1
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0, j = n-1;
		while (i < m && j >= 0){
			if(target < matrix[i][j]) j--;
			else if(target > matrix[i][j]) i++;
			else return true;
		}
		return false;
	}
}
