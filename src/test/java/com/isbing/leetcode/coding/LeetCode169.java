package com.isbing.leetcode.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2020/3/20 17:55
 */
public class LeetCode169 {
	@Test
	public void test(){
		System.out.println(majorityElement_1(new int[]{3,2,3,3}));
		System.out.println(majorityElement_2(new int[]{3,2,3,3}));
	}

	// 哈希表法，时间o(n) 空间o(n)
	public int majorityElement_1(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int key = nums[i];
			if(map.containsKey(key)){
				map.put(key,map.get(key) + 1);
			}else{
				map.put(key,1);
			}
		}
		// 将每个数字对应的出现出现都存储到map中了，然后找出最大的value值
		int maxValue = Integer.MIN_VALUE;
		int maxKey = Integer.MIN_VALUE;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if(maxValue < value){
				maxValue = value;
				maxKey = key;
			}
		}
		return maxKey;
	}

	// 摩尔投票算法 比较消除 时间o(n) 空间o(1)
	public int majorityElement_2(int[] nums) {
		int count = 0, key = 0;
		for(int i=0; i<nums.length; i++){
			// 当发现count为0的时候 就要初始化了
			if(count == 0){
				count = 1;
				key = nums[i];
			}else{
				if(key == nums[i]) count++;
				else count--;
			}
		}
		return key;
	}

}
