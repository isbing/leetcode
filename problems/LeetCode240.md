---
title: LeetCode240-搜索二维矩阵
date: 2019-07-04
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。

每列的元素从上到下升序排列。

示例:

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = 5，返回 true。

给定 target = 20，返回 false。

## 分析

### 暴力解法
直接遍历这个二维数组，对于每一个数字都去与target进行比较

时间O(M*N)  空间O(1)
### 优化解
```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
分析：对于目标值5.假设当前指针在第一排的最后一个位置上，为15

移动原理：每次移动都要逼近目标值

- 15>5，这个时候15假如向下移动到19，竖排是递增的，这与5的距离更大了，所有向左移动到11，就与目标值逼近了
- 可以总结出。当前指针值 大于 目标值，说明竖排的最小都比你大，就需要横向移动
- 当前指针值 小于 目标值，说明横排的都会比你小，只能纵向移动，以此来逼近

时间O(M+N) 空间O(1) 最坏情况下 就是所有位置都游荡一遍

## 解答

````java
import org.junit.Test;
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

````









