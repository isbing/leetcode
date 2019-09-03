---
title: LeetCode64-最小路径和
date: 2019-08-1
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:
```

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

## 分析

分析题目 

从最左上角开始的那一行 只能向右走

从最左上角开始的那一列 只能向下走

而从a(1,1)开始的点，就可以右边 下边 都能走了。

我们就可以总结方程式

1. 使用d[i][j] 表示从d[0][0] 走到d[i][j] 此时的最小路径和
2. 初始化最左上角的那一行 d[0][j]=d[0][j-1]+a[0][j]
3. 初始化最左上角的那一列 d[i][0]=d[i-1][0]+d[i][0]
4. 其余的点，都是要么从上，要么从左走过来的。这两个最小的值+当前值
d[i][j]=min(d[i-1][j],d[i][j-1])+a[i,j]
5. 最后这个d[i-1][j-1] 就是最小路径和

用图画解释为：

题目给定
```$xslt
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
```

初始化左上角的那一行
```$xslt
[
  [1,4,5],
  [1,5,1],
  [4,2,1]
]
```

初始化左上角的那一列
```$xslt
[
  [1,4,5],
  [2,5,1],
  [6,2,1]
]
```

初始化其余的数字 都是取最小值+当前值 例如对于中间元素5分析 得用2+5=7
```$xslt
[
  [1,4,5],
  [2,7,6],
  [6,8,7]
]
```

即 最小路径和为 7.

Time: O(m*n), Space: O(m*n)


## 解答

````java
import org.junit.Test;
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


````









