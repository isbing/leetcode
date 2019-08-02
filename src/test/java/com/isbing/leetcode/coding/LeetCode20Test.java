package com.isbing.leetcode.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
