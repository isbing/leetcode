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
public class LeetCode64Test {

	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return 0;
		// 行
		int m = grid.length;
		// 列
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		// 初始化 左上角的那一行
		for(int i=1; i<n; i++){
			// 0,1  0,2
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		// 初始化 左上角的那一列
		for(int i=1; i<m; i++){
			// 1,0 2,0
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		// 填充其余数据
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				int result = Math.min(dp[i-1][j],dp[i][j-1]);
				dp[i][j] = result + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}
}
