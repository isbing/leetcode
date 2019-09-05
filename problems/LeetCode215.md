---
title: LeetCode215-数组中第K大的元素
date: 2019-08-2
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
```$xslt
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```
示例 2:
```$xslt
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。


## 分析
### 普通法
求数组中第K大的数，我们直接将数组一个从大到小排列，然后取第K-1位置上面的数据 就OK了

时间复杂度为 o(nlogn) 空间为o(1)

### 大神法
[3,2,1,5,6,4]

因为是要求第K大的数字，我们就维护一个TOP K的小顶堆，然后此时的堆顶元素就是第K大的数字

我突然脑子有点转不过来弯了 为啥此时的堆顶元素会是第K大的数字呢？

我们可以设想，此时K为2，我们构造出来的小顶堆，最后就是两个元素 小顶堆中，堆顶是最小的

此时两个数里面，不是堆顶的是最大的数字，你想想，此时堆顶元素不就是第2大的数字了么

Time: O(n*log(k)), Space: O(k)

### 神仙法
我们可以借用快排的选取函数，partition思想

[3,2,1,5,6,4]

我们选取第一个3作为pri位置，ij一前一后

一趟下来，比pri大的数字 都在它的右边，比pri小的数字 都在它的左边

然后查看当前 i是否等于 k-1，如果不等 是看大还是小，选取一半的数字 再次进行partition

知道i == k-1，此时的数字 就是第K大的数字

快排的算法 与前期数组的杂乱程度有关，越杂乱 就越快 到了o(n)。

可以一开始 先用随机洗牌 清洗一下数据，最后就是O(n) 空间 O(1)

Time(avg): O(n), Time(worst): O(n^2), Space: O(1)



## 解答

````java
import org.junit.Test;
public class LeetCode215Test {

	@Test
	public void test(){
		System.out.println(findKthLargest_1(new int[]{4,2,8,1,8},2));
	}

	// 大牛法
	public int findKthLargest_1(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for(int num : nums){
			if(queue.size() < k){
				queue.add(num);
			}else if(num > queue.peek()){
				queue.poll();
				queue.add(num);
			}
		}
		return queue.peek();
	}

	// 神仙法
	public int findKthLargest_2(int[] nums, int k) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int p = partition(nums, low, high);
			if (p == k-1) return nums[p];
			else if (p > k-1) high = p - 1;
			else low = p + 1;
		}
		return -1;
	}

	int partition(int[] nums, int low, int high) {
		int pivot = nums[low], i = low, j = high;
		while (i < j) {
			while (i < j && nums[j] < pivot) --j;
			if (i < j) swap(nums, i, j);
			while (i < j && nums[i] >= pivot) ++i;
			if (i < j) swap(nums, i, j);
		}
		return i;
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}


````









