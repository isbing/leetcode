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
public class LeetCode22Test {

	@Test
	public void test(){
		System.out.println(generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate(result,"",n,n);
		return result;
	}

	private void generate(List<String> result, String str, int left, int right) {
		if(left == 0 && right == 0){
			result.add(str);
		}else{
			if(left > 0){
				generate(result,str+"(",left-1,right);
			}
			if(right > left){
				generate(result,str+")",left,right-1);
			}
		}
	}
}
