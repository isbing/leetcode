package com.isbing.leetcode.coding;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by song bing
 * Created time 2020/3/6 12:21
 */
public class LeetCode167 {

	@Test
	public void test(){
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
	}

	// 最优解法
	public int[] twoSum(int[] numbers, int target) {
		int i = 0,j = numbers.length-1;
		while (i < j){
			if(numbers[i] + numbers[j] < target){
				i++;
			}else if(numbers[i] + numbers[j] > target){
				j--;
			}else{
				return new int[]{i+1,j+1};
			}
		}
		return new int[]{-1,-1};
	}
}
