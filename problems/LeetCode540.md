---
title: LeetCode540-有序数组的单身数字
date: 2019-08-3
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例 1:
```$xslt
输入: [1,1,2,3,3,4,4,8,8]
输出: 2
```

示例 2:
```$xslt
输入: [3,3,7,7,10,11,11]
输出: 10
```

注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。


## 分析

### 普通法
数组中的所有数字全部 抑或一下，最后的数字就是单身数字

Time: O(n), Space: O(1)

> 要知道，两个相同的数 抑或是0，0抑或一个数字 就是它本身

### 优化法
题目给到的条件是 有序数组，我们用普通法做完，发现没用到这个条件。。

既然是有序数组，我们就可以很轻松的想到 可以使用 二分查找！

[3,3,7,7,10,11,11]

1. low=0,high=6
2. 接下来我们要确定mid的位置。这有三种情况
- mid指向的数字 等于 它左边的数字
- mid指向的数字 等于 它右边的数字
- mid指向的数字 既不等于它的左边数字 也不等于 它的右边数字
3. 为了处理的统一，我们强制要求 mid一定要指向两个相同数字中它左边的数字
4. 同时最后看mid与low之间相差的数字
5. 如果是偶数，说明左边是成双成对的，就去右边找 low = mid + 2
6. 如果是奇数，就说明左边有单身狗，去左边，high = mid - 1

Time: O(log(n)), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode540Test {

	@Test
	public void test(){
		System.out.println(singleNonDuplicate_1(new int[]{3,3,7,7,10,11,11}));
	}

	public int singleNonDuplicate_1(int[] nums) {
		int result = 0;
		for(int num : nums){
			result ^= num;
		}
		return result;
	}

	public int singleNonDuplicate_2(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int low = 0,high = nums.length - 1;

		while (low <= high){
			int mid = low - (low-high)/2;
			// 看是与左边的相等 还是右边的相等
			if(mid-1 >= 0 && nums[mid] == nums[mid-1]){
				// 与左边的相等 mid就统一为左边
				mid--;
			}else if(mid+1 < nums.length && nums[mid] == nums[mid+1]){
				// 本来就是左边 无需处理
			}else{
				// 单身数字
				return nums[mid];
			}
			// 确定low high的位置
			if((mid-low) % 2 == 0){
				// 偶数 就去 右边找
				low = mid + 2;
			}else{
				// 左边找
				high = mid - 1;
			}
		}
		return 0;
	}
}


````









