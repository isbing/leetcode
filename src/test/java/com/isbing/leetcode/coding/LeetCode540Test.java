package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
