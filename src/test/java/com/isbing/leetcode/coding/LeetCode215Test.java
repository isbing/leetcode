package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
