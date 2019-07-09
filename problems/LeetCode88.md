---
title: LeetCode88-合并两个有序数组
date: 2019-07-06
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。

你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:

nums1 = [1,2,3,0,0,0], m = 3

nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

## 分析
### 解法1
1 3 9 11 0 0 0

2 13

很常规的思路 肯定是 两个指针指向数组的首位元素，此时为1，2。因为2>1，就需要将数组1中元素后移，将2赋值进来

这样肯定会 移动次数比较多

### 解法二
为了减少移动的次数，我们可以 将两个指针都设置到数组中的最后面，并且插入位置 也从最后面来

例如 

nums1 = [1,3,9,11,0,0,0], m = 4

nums2 = [2,13],       n = 2

1. 首先i指向m-1处，j指向n-1处，i，j分别指向数组中的最后面
2. 插入初始位置为 m+n-1.
3. 首先11<13,那么将nums[m+n-1] = nums2[j]，j--。直到i,j<0，再将多余出来的 依次赋值完毕

时间0(M+N) 空间O(1)。 M+N因为 最糟糕的情况就是每个数据都依次塞进去。

这种思路是直接赋值，没有移位的操作

## 解答

````java
import org.junit.Test;
public class LeetCode88Test {

	@Test
	public void test(){
		int[] nums1 = {1,3,9,11,0,0,0};
		int[] nums2 = {2,13};
		merge(nums1,4,nums2,2);
		System.out.println(Arrays.toString(nums1));
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1,j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0){
			if(nums1[i] <= nums2[j]){
				nums1[k] = nums2[j];
				j--;
			}else{
				nums1[k] = nums1[i];
				i--;
			}
			k--;
		}
		// nums1有剩余
		while (i >= 0){
			nums1[k--] = nums1[i--];
		}
		while (j >= 0){
			nums1[k--] = nums2[j--];
		}
	}
}


````









