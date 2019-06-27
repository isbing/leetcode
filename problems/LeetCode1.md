---
title: LeetCode1-两数之和
date: 2019-06-01
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
这个解法应该是大家都能直接想到的。

外层遍历这个数组，假如第一个数，然后从当前数的下一个开始循环相加 看是否等于给定值。

第一次大循环结束，就开始第二个数 继续开始里层的循环

两层循环暴力 空间为O(1) 时间O(n方)

### 优化解
使用hashMap 根据key得到value 这个是比较效率的。O(1)

用 2 7 11 15 target=9 来分析。

1. map中的存储为 (数组元素，当前角标)
2. 首先遍历到2，9-2=7。判断7是否在map中。若不在，就将 (2,0)装入map。
3. 然后到7了，9-7=2,。发现在map中，完美解决

用哈希表 空间为O(n) 时间O(n)

## 解答

````java
import org.junit.Test;
public class LeetCode1Test {

	@Test
	public void test(){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSumBao(nums,target)));
		System.out.println(Arrays.toString(twoSumYou(nums,target)));
	}

	public int[] twoSumBao(int[] nums, int target) {
		if(nums == null || nums.length < 2){
			return new int[]{-1,-1};
		}
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}

	public int[] twoSumYou(int[] nums, int target) {
		if(nums == null || nums.length < 2){
		    return new int[]{-1,-1};
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int otherValue = target - nums[i];
			if(map.containsKey(otherValue)){
				return new int[]{map.get(otherValue),i};
			}else{
				map.put(nums[i],i);
			}
		}
		return new int[]{-1,-1};
	}
}


````









