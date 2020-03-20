---
title: LeetCode169-数组中出现次数大于⌊n/2⌋的元素
date: 2020-03-20
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
比较消除的思路，因为数组中一定会存在一个众数，2 2 3 3 2，比如这样的 比较消除之后，一定还会存在一个数

3 2 3 3

1. key=0，count=0,第一次循环 遍历到3 当发现count为0时 初始化为1，key指向这个元素
2. 第二次循环 遍历到 2 count-1=1-1=0
3. 第三次循环 遍历到 3, 当发现count为0 初始化为1，每次初始化的时候，key才变动
4. 第四次循环 遍历到3 count++，最后返回最后存在的数字即可

Time: O(n), Space: O(1)

## 总结
1. 一个数组中返回出现次数一半的元素，用hashMap，每个数字对应的出现次数存储在map，然后比较谁的value到 时间空间都为o(n)
2. 第二种方法，因为题目中规定了数组中一定会存在这样的数字，可以用比较消除法，相同++，不同--，时间为o(n) 空间为o(1)

## 解答

````java
import org.junit.Test;
public class LeetCode169 {
	@Test
	public void test(){
		System.out.println(majorityElement_1(new int[]{3,2,3,3}));
		System.out.println(majorityElement_2(new int[]{3,2,3,3}));
	}

	// 哈希表法，时间o(n) 空间o(n)
	public int majorityElement_1(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int key = nums[i];
			if(map.containsKey(key)){
				map.put(key,map.get(key) + 1);
			}else{
				map.put(key,1);
			}
		}
		// 将每个数字对应的出现出现都存储到map中了，然后找出最大的value值
		int maxValue = Integer.MIN_VALUE;
		int maxKey = Integer.MIN_VALUE;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if(maxValue < value){
				maxValue = value;
				maxKey = key;
			}
		}
		return maxKey;
	}

	// 摩尔投票算法 比较消除 时间o(n) 空间o(1)
	public int majorityElement_2(int[] nums) {
		int count = 0, key = 0;
		for(int i=0; i<nums.length; i++){
			// 当发现count为0的时候 就要初始化了
			if(count == 0){
				count = 1;
				key = nums[i];
			}else{
				if(key == nums[i]) count++;
				else count--;
			}
		}
		return key;
	}

}



````









