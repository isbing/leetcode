---
title: LeetCode74-二维数组的二分查找
date: 2019-07-20
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。

每行的第一个整数大于前一行的最后一个整数。

示例 1:

```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
```

示例 2:
```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
```

## 分析

二维数组的二分查找，也是与一维数组的思路相似

可以将这个二维数组平摊出来成为一个一维数组，只不过mid算值时得转换为二维数组的坐标

```
matrix = [
  [1, 3,  5],
  [7, 9, 11]
]
target = 9
```

初始化二维数组 matrix(m*n)
1. 首先将这个数组看成 {1,3,5,7,9,11}
2. 那么初始化low=0 high=m*n-1=6-1=5(m*n 可以表示所有的元素了)
3. mid=2对应二维数组的下标是什么呢？行=mid/n  列=mid%n mid=2对应的下标为(0,2)=5
4. mid<target low=mid+1=3 high=5
5. 那么mid=4对应下标为(1,1)=9 找到了，返回(-1,-1)

> 核心就是要找到对应的mid数在二维数组的下标。（mid/n,mid%n）==>n为数组的列

Time: O(log(m*n)), Space: O(1)

## 解答

````java
import org.junit.Test;
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


````









