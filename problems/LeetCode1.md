---
title: LeetCode1-两数之和
date: 2020-03-06
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9

所以返回 [0, 1]

## 分析
### 暴力解
这个解法应该是大家都能直接想到的。直接两层for循环，看两数相加是否等于target值

两层循环暴力 空间为O(1) 时间O(n方)

### 优化解
使用hashMap 将每个数字以及对应的角标用map结构存储，遍历一个数字的时候，去map中找第二个数

用 2 7 11 15 target=9 来分析。

1. map中的存储为 (数组元素，当前角标)
2. 首先遍历到2，9-2=7。判断7是否在map中。若不在，就将 (2,0)装入map。
3. 然后到7了，9-7=2,。发现在map中，完美解决

用哈希表 空间为O(n) 时间O(n)

## 总结
1. 暴力解法是很容易想到的，优化思路一般都用空间换时间
2. 两数之和，通过一轮循环可以确定一个数字，那么第二个数字就可以不再用循环了，去辅助表里面查
3. map.containsKey(two) 这个时间复杂度为o(1)

## 解答

````java
import org.junit.Test;
public class LeetCode1 {
	@Test
	public void test(){
		System.out.println(Arrays.toString(twoSum_1(new int[]{2,7,11,15},9)));
		System.out.println(Arrays.toString(twoSum_2(new int[]{2,7,11,15},9)));
	}

	// 暴力解法 直接两层循环 搞定
	public int[] twoSum_1(int[] nums, int target) {
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}

	// 优化解法，典型的空间换时间 key为num，value为index
	public int[] twoSum_2(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int one = nums[i];
			int two = target - one;
			// 查看第二个值 是否在map中，如果在 就最好了，如果不在 将当前值以及角标放入map中
			if(map.containsKey(two)){
				return new int[]{map.get(two),i};
			}else{
				map.put(one,i);
			}
		}
		return new int[]{-1,-1};
	}
}

````









