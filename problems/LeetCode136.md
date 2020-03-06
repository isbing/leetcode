---
title: LeetCode136-单身数字
date: 2020-03-06
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]

输出: 1

示例 2:

输入: [4,1,2,1,2]

输出: 4

## 分析

### 暴力解
任何人都能想到的暴力解法：两层循环。外层循环中的某一个数，去剩下的里层循环里面找。

如果找到了，就继续下次大循环。如果没有找到，就是题目要求的数字

这种暴力解法 时间为O(N方) 空间为O(1)

### 优化解
可以得知，每次给定的数组一定会是奇数个，并且最后会剩一个没有配偶的数字。

很明显的一个思路就是 用两次数列和 把单身的数字的配偶找出来。

- 两次数列和的时候，需要找出不重复的数字，需要使用set来过滤

[4,1,2,1,2]
1. set一遍之后 得到的无重复数字为 4 1 2
2. 都有对象的整数和：(4+1+2)*2=14
3. 原有数组的整数和：4+1+2+1+2=10
4. 单身数字为 14-10=4

时间复杂度为 0(N).空间复杂度为O(N)

### 进一步的优化解
将空间复杂度降至O(1).可以使用抑或运算

抑或运算的规则：
- x ^ x = 0   0 ^ y = y  
- 两个相同的数字（二进制）抑或为0，不同的数字（二进制）抑或为1。
- 而且满足交换律
- 对于二进制来说 相同为0 不同为1。对于十进制的来说 运算法则是第一条

[4,1,2,1,2]来说：

4^1^2^1^2 等价于 1^1^2^2^4 = 0^4=4..最后得到的就是4

时间复杂度为 0(N).空间复杂度为O(1)

## 总结
1. 暴力法是很容易想到的，用每一个数字去列表里面找，若没找到，就是单身数字，时间为o(n方)
2. 使用set，第一次循环将所有的数据存入set，set中数据和*2-原数组=单身数字，时间空间都是o(n)
3. 使用抑或运算， y ^ y = 0。因为抑或，相同为0，两个相同的数字抑或之后二进制位全是0，结果就是0
4. 0 ^ y = y，一个数字跟0抑或，就是它本身，时间为o(n) 空间为o(1)

## 解答

````java
import org.junit.Test;
import java.util.*;
public class LeetCode136Test {

	@Test
	public void test(){
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber2(nums));
		System.out.println(singleNumber3(nums));
	}

	// 暴力略
	public int singleNumber1(int[] nums) {
		return -1;
	}

	// 时间O(N) 空间O(N)
	public int singleNumber2(int[] nums) {
		if(nums == null){
			return -1;
		}
		Set<Integer> set = new HashSet<>();
		int originSum = 0;
		int setSum = 0;
		for(int i=0; i<nums.length; i++){
			// 循环的过程中 将set填充 将和算出来
			originSum += nums[i];
			boolean flag = set.add(nums[i]);
			if(flag){ // 添加成功
				setSum += nums[i];
			}
		}
		return setSum * 2 - originSum;
	}

	// 时间O(N) 空间O(1)
	public int singleNumber3(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}
}


````









