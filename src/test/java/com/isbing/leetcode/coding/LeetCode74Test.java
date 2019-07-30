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
public class LeetCode74Test {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null) return false;
		if(matrix.length == 0) return false;
		if(matrix[0] == null) return false;
		if(matrix[0].length == 0) return false;
		// 行
		int m = matrix.length;
		// 列
		int n = matrix[0].length;

		int low = 0;
		int high = m*n-1;

		while (low <= high){
			int mid = low + (high-low)/2;
			// 计算mid在二维数组中的角标
			int row = mid / n;
			int column = mid % n;
			if(matrix[row][column] == target){
				return true;
			}else if(matrix[row][column] < target){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}

		return false;
	}
}
