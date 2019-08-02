---
title: LeetCode22-括号的合法排列
date: 2019-07-24
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

## 分析
假设n=3 ，那么可能的结果为：
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```
用递归的思路，左括号>0时 可以先一直放左括号，当右括号数量比左括号多，就回溯放右括号

n=3 代表 左括号有3个，右括号有3个

1. 当left = right = 0时，就是一个合法的括号排列
2. 否则，当left>0时 就放左括号 f(result,str+"(",left-1,right)
3. 当right>left时，就可以放呦括号了 f(result,str+")",left,right-1)

## 解答

````java
import org.junit.Test;
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


````









