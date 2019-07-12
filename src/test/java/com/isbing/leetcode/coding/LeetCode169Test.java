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
public class LeetCode169Test {

	@Test
	public void tt(){
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
	}


	// 时间O(N) 空间O(N)
	public int majorityElement(int[] nums) {
		// [2,2,1,1,1,2,2]
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			// key存在 次数+1  key不存在 次数赋值为1
			if(map.containsKey(nums[i])){
				map.put(nums[i],map.get(nums[i])+1);
			}else{
				map.put(nums[i],1);
			}
		}
		int max = 0;
		int key = 0;//指向max的那个key
		// 遍历这个map 谁最大 就替换这个max
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		return key;
	}


	// 时间O(N) 空间O(1) 摩尔投票算法
	public int majorityElementV2(int[] nums) {
		// 3 2 3 3
		int currentNum = nums[0];
		int currentCount = 1;

		for(int i=1; i<nums.length; i++){
			if(currentCount <= 0){
				// 次数小于等于0，就直接
				currentNum = nums[i];
				currentCount = 1;
			}else{
				if(nums[i] == currentNum){
					currentCount++;
				}else{
					currentCount--;
				}
			}
		}
		return currentNum;
	}
}
