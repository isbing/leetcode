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
		System.out.println(majorityElementV2(nums));
	}

	// 时间0(N)  空间0(N)
	public int majorityElement(int[] nums) {
		if(nums == null) return 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int num : nums){
			if(map.containsKey(num)){
				map.put(num,map.get(num)+1);
			}else{ // 不存在 次数为1
				map.put(num,1);
			}
		}
		int maxCount = 0;
		int maxCountKey = 0;
		// 遍历这个map
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue() > maxCount){
				maxCount = entry.getValue();
				maxCountKey = entry.getKey();
			}
		}
		return maxCountKey;
	}

	// 时间0(N)  空间0(1)
	public int majorityElementV2(int[] nums) {
		if(nums == null) return 0;
		// 摩尔投票算法  2,1,2,1,1,2,2
		// 初始化 就是指向第一个数字
		int maxCount = 1;
		int maxCountKey = nums[0];
		for(int i=1; i<nums.length; i++){
			if(maxCount <= 0){
				// 重新开始取
				maxCountKey = nums[i];
				maxCount = 1;
			}else{
				// 相同 次数+1 不相同次数-1
				if(maxCountKey == nums[i]){
					maxCount++;
				}else{
					maxCount--;
				}
			}
		}
		return maxCountKey;
	}
}
