---
title: LeetCode46-全排列
date: 2019-07-05
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]

输出:
```
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## 分析
递归思路：

先把第一个数字1固定下来。让剩下的2 3进行全排列。

剩下的开启循环后 将2固定下来 3进行全排列 3只有一个数字 就打印123 

此时固定的是2 回缩到上一版本23的时候 就要开始固定3 打印132

这个时候 固定的1 就结束了 恢复到原始状态 开始固定2。。2全部打印完了 恢复初始状态 再开始固定3
	
Time: O(n*n!), Space: O(n)

## 解答

````java
import org.junit.Test;
public class LeetCode46Test {

	// Time: O(n*n!), Space: O(n)
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		for (int num: nums) list.add(num);

		permuteRec(list, 0, result);
		return result;
	}
	
	private void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
		if (start == nums.size()) {
			result.add(new ArrayList<>(nums));
		} else {
			for (int i = start; i < nums.size(); ++i) {
				Collections.swap(nums, i, start);
				permuteRec(nums, start + 1, result);
				Collections.swap(nums, i, start);
			}
		}
	}
}


````









