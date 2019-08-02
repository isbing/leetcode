---
title: LeetCode384-随机洗牌
date: 2019-07-27
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

这个题目说的是，给你一个整数数组表示一副牌，

你要写一个随机洗牌函数来返回这个数组的一个排列。

并且要保证每次返回的排列都是等概率的。假设已经给你一个完美的随机数生成器。

## 分析

假设给定数组为 {1,2,3,4,5}

> 首先解释等概率抽取是怎么回事

不知道大家高中学习不放回抽取时 有没有这样的疑问？

- 5个人抽取5张牌，第一张牌被抽到的概率是 1/5
- 现在剩下4个人4张牌，第二个人抽取牌的概率就是 1/4了。

为什么会说 不放回抽取是等概率事件呢？哈哈 我可是纠结了很久的！

第一个人抽取牌的概率是 1/5 是毫无疑问的。

第二轮抽时每个没在第一轮被抽到的概率是4/5，然后还有现在被抽到的概率1/4,两个相乘=1/5。因为你并不知道第一轮哪个被抽到，算第二轮是还要考虑第一轮

第三轮（同理）。。。。


也就是说 不放回的抽取，第二轮以后的算法，需要结合前面的数据来算！！

知道了这个等概率是啥意思之后 这个题目就好说了。

对于数组 {1,2,3,4,5}
1. 首先设置i = s.length-1 = 4。也就是说 第一次抽取在[0,4]之间抽取
2. 第一次抽到了2，对应数字为3。此时的3是不能参与第二轮的抽奖的 将3与最后一个数字替换，
成为{1,2,5,4,3} 然后让i--。也就是说 从 {1,2,5,4} 继续抽奖 即可
3. 这样每次替换，都没有改变原数组。最后就返回这个数组就可以了

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode384Test {

	private Random random = new Random();

	public int[] shuffle(int[] nums) {
		for(int i=nums.length-1; i>=0 ; i--){
			int j = random.nextInt(i + 1);
			swap(nums,i,j);
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	@Test
	public void tt(){
		System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,5})));
	}
}


````









