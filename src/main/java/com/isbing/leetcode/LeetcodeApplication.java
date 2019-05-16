package com.isbing.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class LeetcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
	}


	/**
	 * 异或的运算方法是一个二进制运算：
	 * 1^1=0
	 * 0^0=0
	 * 1^0=1
	 * 0^1=1
	 * 两者相等为0,不等为1.
	 * 这样我们发现交换两个整数的值时可以不用第三个参数。
	 * 如a=11,b=9.以下是二进制
	 * a=a^b=1011^1001=0010;
	 * b=b^a=1001^0010=1011;
	 * a=a^b=0010^1011=1001;
	 * 这样一来a=9,b=13了。
	 */

}
