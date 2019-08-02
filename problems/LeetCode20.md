---
title: LeetCode20-有效的括号
date: 2019-07-23
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"

输出: true

示例 2:

输入: "()[]{}"

输出: true

示例 3:

输入: "(]"

输出: false

## 分析
假定给定括号为 {[()]}

采用栈实现
1. 遍历这个字符串，当遇见 { ( [ 这三个左边括号时 就入栈。
2. 当遇见右边的括号时 就出栈 与当前字符进行比较。只要不相等，就返回false
3. 相等继续下次循环，循环过程中当要出栈的时候出现空栈，也要返回false
4. 当结束循环后 最后栈为空，就可以返回true

> 补充知识：空栈 pop时 会异常，所以需要第三步的判断

Time: O(n), Space: O(n)
## 解答

````java
import org.junit.Test;
public class LeetCode20Test {

	@Test
	public void test(){
		System.out.println(isValid("()[]{}"));
	}

	public boolean isValid(String s) {
		if(s == null || s.length() == 0) return true;
		// 利用栈 存放左边括号
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(') stack.push('(');
			else if(s.charAt(i) == '[') stack.push('[');
			else if(s.charAt(i) == '{') stack.push('{');
			else if(stack.isEmpty()) return false;//表示第一次出现右括号，空栈出栈，会异常
			else if(s.charAt(i) == ')'){
				// 右边括号需要出栈
				Character pop = stack.pop();
				if(pop != '('){
					return false;
				}
			}
			else if(s.charAt(i) == ']'){
				// 右边括号需要出栈
				Character pop = stack.pop();
				if(pop != '['){
					return false;
				}
			}
			else if(s.charAt(i) == '}'){
				// 右边括号需要出栈
				Character pop = stack.pop();
				if(pop != '{'){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}


````









