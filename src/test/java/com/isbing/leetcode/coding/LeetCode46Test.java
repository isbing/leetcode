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
public class LeetCode46Test {

	// Time: O(n*n!), Space: O(n)
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		for (int num: nums) list.add(num);

		permuteRec(list, 0, result);
		return result;
	}

	private void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
		if (start == nums.size()) {
			result.add(new ArrayList<>(nums));
		} else {
			for (int i = start; i < nums.size(); ++i) {
				Collections.swap(nums, i, start);
				permuteRec(nums, start + 1, result);
				Collections.swap(nums, i, start);
			}
		}
	}
}
