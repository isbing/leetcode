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
public class LeetCode121Test {

	@Test
	public void test(){
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit_2(prices));
	}

	// 暴力解法
	public int maxProfit_1(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int max = 0;
		for(int i=0; i<prices.length; i++){
			for(int j=i+1; j<prices.length; j++){
				int result = prices[j] - prices[i];
				if(result > max){
					max = result;
				}
			}
		}
		return max;
	}

	// 优化解法
	public int maxProfit_2(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int max = 0;
		int maiRu = prices[0];

		for(int i=1; i<prices.length; i++){
			// 如果当前值 比 买入值 小 就可以替换掉 买入值
			if(prices[i] < maiRu){
				maiRu = prices[i];
			}else{
				// 否则 就说明 当前值 比我的 值大，这个是 卖出价格
				int maiChu = prices[i];
				int result = maiChu - maiRu;
				if(result > max){
					max = result;
				}
			}
		}

		return max;
	}
}
