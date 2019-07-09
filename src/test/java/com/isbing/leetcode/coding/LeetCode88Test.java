package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode88Test {

	@Test
	public void test(){
		int[] nums1 = {1,3,9,11,0,0,0};
		int[] nums2 = {2,13};
		merge(nums1,4,nums2,2);
		System.out.println(Arrays.toString(nums1));
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1,j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0){
			if(nums1[i] <= nums2[j]){
				nums1[k] = nums2[j];
				j--;
			}else{
				nums1[k] = nums1[i];
				i--;
			}
			k--;
		}
		// nums1有剩余
		while (i >= 0){
			nums1[k--] = nums1[i--];
		}
		while (j >= 0){
			nums1[k--] = nums2[j--];
		}
	}
}
