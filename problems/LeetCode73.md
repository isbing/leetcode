---
title: LeetCode73-矩阵置0
date: 2019-07-21
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:
```
输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```
示例 2:
```
输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```

## 分析

对于矩阵:
```
[
  [1,2,3,4],
  [4,6,0,5],
  [0,2,1,1]
]
```
### 常规解
可以使用两个一维数组（行数组row，列数组column）

row = {0,0,0} column = {0,0,0,0}

遍历这个矩阵，当出现为0的时候，看下角标

对于第一个0，角标为 (1,2) 即将row = {0,1,0} column = {0,0,1,0} 

对于第二个0，角标为 (2,0) 即将row = {0,1,1} column = {1,0,1,0}

再次遍历矩阵，当row[i] == 1 或者 column[j] == 1时，将当前元素置为0

Time: O(m*n), Space: O(m+n)

### 优化解
第0行标记 row0=false 第0列标记 column0=false

首先分析第0行第0列，假设第0行或者第0列中出现了0，将将其相应字段标记为true

然后遍历矩阵从第一行第一列的位置开始，每出现数字0，将第0行的这个列 将第这个行的第0列标记为0

```
[
  [1,2,3,4],
  [4,6,0,5],
  [0,2,1,1]
]
```
1. 初始化 row0 = false column0 = false
2. 判断第0行第0列 row0 = false column0 = true
3. 从(1,1)开始遍历，对于出现的0为（1,2）即将这一行的第0列标记为0，这一列的第0行标记为0，此时如下：
```
[
  [1,2,0,4],
  [0,6,0,5],
  [0,2,1,1]
]
```
1. 接着上面的3分析
2. 从(1,1)循环到最后 都是给第0行 第0列的数据 打标了。
3. 再次从(1,1)开始循环到最后，只要这个数字中 第0行第0列中的数据为0，就直接将当前数据(i,j)置为0
4. 此时处理的数据是不包含第0行第0列中的数据。如图：
```
[
  [1,2,0,4],
  [0,0,0,0],
  [0,0,0,0]
]
```
目前就是第0行第0列的数据没有处理了，发现第0列的标识为true，将第0列的数据标为0即可
```
[
  [0,2,0,4],
  [0,0,0,0],
  [0,0,0,0]
]
```

Time: O(m*n), Space: O(1)

## 解答

````java
import org.junit.Test;
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


````









