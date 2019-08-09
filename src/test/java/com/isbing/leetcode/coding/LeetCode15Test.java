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
public class LeetCode15Test {

	@Test
	public void test(){
		List<List<Integer>> lists = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println(lists);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		// 先将数组排序
		Arrays.sort(nums);
		int k = nums.length-1;
		// 只要k >= 0时 就一直循环。。
		while (k >= 2 && nums[k] >= 0){
			int target = -nums[k];

			// 确定下来k之后，就初始化i,j 头尾一起逼近
			for(int i=0,j=k-1; i<j; ){
				int result = nums[i] + nums[j];
				if(result < target){ // 说明小数字不给力 i右移
					i++;
				}else if(result > target){ // 说明大数字太给力 j左移
					j--;
				}else{
					// 相等的时候 添加到结果集
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					resultList.add(list);
					// 此时圆满情况 就是i右移，j左移 但是移动的数字又不能与现在的数字相同
					while (i<j && nums[i] == nums[i+1]) i++;
					while (i<j && nums[j] == nums[j-1]) j--;
					// 再次移动 就是不相等的数字了
					i++;
					j--;
				}
			}
			// k移动之后 也不能与当前数字一样
			while (k >= 2 && nums[k] == nums[k-1]) k--;
			// 这次的移动 就是一定不相等的数字
			k--;
		}
		return resultList;
	}
}
