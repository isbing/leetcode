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
public class LeetCode73Test {

	//Time: O(m*n), Space: O(1)
	public void setZeroes_1(int[][] matrix) {
		// 记录第0行 第0列的标识 最后有用的
		boolean row0 = false;
		boolean column0 = false;
		int m = matrix.length;
		int n = matrix[0].length;
		// 检测行的情况 标记结果为第0列
		for(int i=0; i<m; i++){
			if(matrix[i][0] == 0){
				column0 = true;
				break;
			}
		}
		// 检测列的情况-标记结果为第0行
		for(int i=0; i<n; i++){
			if(matrix[0][i] == 0){
				row0 = true;
				break;
			}
		}
		// 从(1,1)开始继续标记数据
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][j] == 0){
					// 标记最左边 最上面的数据
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		// 从(1,1)开始处理数据
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		// 处理第0行第0列标识的数据
		if(column0){
			for(int i=0; i<m; i++){
				matrix[i][0] = 0;
			}
		}
		if(row0){
			for(int i=0; i<n; i++){
				matrix[0][i] = 0;
			}
		}
	}


	//Time: O(m*n), Space: O(m+n)
	public void setZeroes_2(int[][] matrix) {
		// 得到矩阵的行列
		int m = matrix.length;
		int n = matrix[0].length;
		// 行数组 列数组
		int[] row = new int[m];
		int[] column = new int[n];

		// 遍历矩阵 将为0的数据的 行列记录到各自的数组里面
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		// 再次遍历矩阵 只要行或者列中出现了1，就需要置0
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(row[i] == 1 || column[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
	}
}
