package com.isbing.leetcode.coding;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode240Test {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null){
			return false;
		}
		if(matrix.length == 0){
			return false;
		}
		int[] temp = matrix[0];
		if(temp == null){
			return false;
		}
		if(temp.length == 0){
			return false;
		}
		// 行数
		int m = matrix.length;
		// 列数
		int n = matrix[0].length;
		// 当前指针 指向第一排最后的那个数
		int i = 0,j = n-1;
		// 循环条件 就是 行列的限制在矩阵框框中
		while (i < m && j >= 0){
			if(matrix[i][j] > target){
				j--;
			}else if(matrix[i][j] < target){
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
}
