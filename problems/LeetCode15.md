---
title: LeetCode15-三数之和
date: 2019-07-29
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

## 分析
### 暴力解
直接三层循环。i指向数组第一个数字，j指向i+1，k指向j+1。看是否这三个数字相加为0

若为0 加入结果集的时候 还得判断一下 当前结果集中是否包含这个结果（可以用一个Set来过滤结果集）

Time: O(n^3), Space: O(n)

### 优化解
先将数组排序 成为 -4 -1 -1 0 1 2

1. k从最大开始2，k<0结束循环
2. 此时K指向2，i，j指向位置为0和k-1开始。而且得需要 a[i] + a[j] = -k = -2
3. -4+1=-3 -3<-2 所以i需要右移 -1+1=0 大于-2 需要j左移 
4. -1+0=-1 > -2 j继续左移 -1 + -1 = -2满足条件
5. 这样一直分析下去即可。

核心思路就是先将数组排序，然后K指向最大数字，用i，j从头尾相互逼近。。

而且需要注意的是，只要出现结果，i,j移动的时候，就不能移动到与他们相等的数字了。。

这样可以直接避免重复集，而不用set过滤了

Time: O(n^2), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode15Test {

	@Test
	public void test(){
		List<List<Integer>> lists = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println(lists);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		// 先将数组排序
		Arrays.sort(nums);
		int k = nums.length-1;
		// 只要k >= 0时 就一直循环。。
		while (k >= 2 && nums[k] >= 0){
			int target = -nums[k];

			// 确定下来k之后，就初始化i,j 头尾一起逼近
			for(int i=0,j=k-1; i<j; ){
				int result = nums[i] + nums[j];
				if(result < target){ // 说明小数字不给力 i右移
					i++;
				}else if(result > target){ // 说明大数字太给力 j左移
					j--;
				}else{
					// 相等的时候 添加到结果集
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					resultList.add(list);
					// 此时圆满情况 就是i右移，j左移 但是移动的数字又不能与现在的数字相同
					while (i<j && nums[i] == nums[i+1]) i++;
					while (i<j && nums[j] == nums[j-1]) j--;
					// 再次移动 就是不相等的数字了
					i++;
					j--;
				}
			}
			// k移动之后 也不能与当前数字一样
			while (k >= 2 && nums[k] == nums[k-1]) k--;
			// 这次的移动 就是一定不相等的数字
			k--;
		}
		return resultList;
	}
}


````









