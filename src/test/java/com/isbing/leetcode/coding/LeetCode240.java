package com.isbing.leetcode.coding;

import org.junit.Test;

/**
 * Created by song bing
 * Created time 2020/3/6 16:53
 */
public class LeetCode240 {

	// 暴力直接搜索
	public boolean searchMatrix_1(int[][] matrix, int target) {
		for(int m=0; m<matrix.length; m++){
			for(int n=0; n<matrix[0].length; n++){
				if(matrix[m][n] == target){
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchMatrix_2(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
		// 行
		int m = matrix.length;
		// 列
		int n = matrix[0].length;
		// 定位到第一行最后一个元素
		int i = 0, j = n-1;
		while (i < m && j >= 0){
			if(matrix[i][j] > target) j--;
			else if(matrix[i][j] < target) i++;
			else return true;
		}
		return false;
	}
}
