---
title: LeetCode169-数组中出现次数大于⌊n/2⌋的元素
date: 2019-07-11
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个大小为 n 的数组，找到其中的众数。

众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]

输出: 3

示例 2:

输入: [2,2,1,1,1,2,2]

输出: 2

## 分析

审题，众数的定义：数组中出现次数大于 一半 的元素。

### 常规解
使用hashMap，对于每个遍历到的数字，都记录一下出现的次数。

例如：[2,2,1,1,1,2,2] map结构为：

（2，4）

（1，3）

循环外面默认一个最大值0，默认一个指向最大值的key

遍历这个map，每遍历到的这个key中的value值比最大值大，就替换

最后返回这个最大值指向的key就OK了

时间O(N) 空间O(N)

### 优美解
可以采用 摩尔投票算法，跟连续子序列最大和一样的思路。比较消除的思路

3 2 3 3

首先当前值为3 出现次数为1.

下次循环 当前值为2 2!=3 出现次数1-1=0 当为0之后，

为0之后 就可以重置 当前值为3 出现次数为1

下次循环 当前值为3 相同就+1.。最后返回的就是 当前值

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode169Test {

	@Test
	public void tt(){
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
		System.out.println(majorityElementV2(nums));
	}

	// 时间0(N)  空间0(N)
	public int majorityElement(int[] nums) {
		if(nums == null) return 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int num : nums){
			if(map.containsKey(num)){
				map.put(num,map.get(num)+1);
			}else{ // 不存在 次数为1
				map.put(num,1);
			}
		}
		int maxCount = 0;
		int maxCountKey = 0;
		// 遍历这个map
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue() > maxCount){
				maxCount = entry.getValue();
				maxCountKey = entry.getKey();
			}
		}
		return maxCountKey;
	}

	// 时间0(N)  空间0(1)
	public int majorityElementV2(int[] nums) {
		if(nums == null) return 0;
		// 摩尔投票算法  2,1,2,1,1,2,2
		// 初始化 就是指向第一个数字
		int maxCount = 1;
		int maxCountKey = nums[0];
		for(int i=1; i<nums.length; i++){
			if(maxCount <= 0){
				// 重新开始取
				maxCountKey = nums[i];
				maxCount = 1;
			}else{
				// 相同 次数+1 不相同次数-1
				if(maxCountKey == nums[i]){
					maxCount++;
				}else{
					maxCount--;
				}
			}
		}
		return maxCountKey;
	}
}


````









