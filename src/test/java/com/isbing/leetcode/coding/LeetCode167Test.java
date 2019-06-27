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
public class LeetCode167Test {

	@Test
	public void test(){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}

	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2){
			return new int[]{-1,-1};
		}
		int begin = 0;
		int end = numbers.length - 1;
		while (begin <= end){
			if(numbers[begin] + numbers[end] == target){
				return new int[]{begin+1,end+1};
			}else if(numbers[begin] + numbers[end] > target){
				// 大数大了，整体需要调小
				end--;
			}else{
				begin++;
			}
		}
		return new int[]{-1,-1};
	}

}
