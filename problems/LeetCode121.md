---
title: LeetCode121-买卖股票的最佳时机
date: 2019-07-31
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:
```

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
```
示例 2:

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

## 分析

### 暴力法
[7,1,5,3,6,4] 给定一个数组，我们两层循环，可以拿到任意两个数字

左边代表 买入价格，右边代表 卖出价格。

右边-左边，如果大于最大值 就替换。

Time: O(n^2), Space: O(1)

### 优化解法
[7,1,5,3,6,4]

1. 初始化买入价格为7.最大利润为0
2. 当卖出价格为1时，卖出<买入，就可以调小一点买入，将买入价格调整为1
3. 当卖出价格为5时，卖出>买入，算取利润为4，并且大于当前利润，就可以将4设置为最大利润
4. 当卖出价格为3时，卖出>买入，算取利润为2，小于当前利润，不变
5. 当卖出价格为6时，卖出>买入，算取利润为5，又大于当前利润，就再替换掉
6. 当卖出价格为4时，卖出>买入，利润为3，不变。。
7. 最后输出最大利润为5


Time: O(n), Space: O(1)


## 解答

````java
import org.junit.Test;
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


````









