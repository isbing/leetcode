---
title: LeetCode9-回文数
date: 2020-03-08
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121

输出: true

示例 2:

输入: -121

输出: false

解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:

输入: 10

输出: false

解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:

你能不将整数转为字符串来解决这个问题吗？

## 分析
解法1：

思路很简单，将这个整数转换为字符串，然后前后指针指向，依次比较

Time: O(N), Space: O(1)

解法2：

不使用字符串的话，可以考虑构造。

例如数字123，我们构造一个数字 321.与之比较就完事了。前提是大于0的数字

123是从左向右构造的，现在需要构造一个 从右到左的数字

构造公式可以采用 y = y * 10 + num 来搞。例如123

1. 首先y=0, 0*10+3 = 3
2. y = 3了，再用2，3*10+2=32
3. y = 32了，再用1，32*10+1=321

Time: O(N), Space: O(1)

## 总结
1. 常规思路就是将数字转为字符串，用字符串的首尾指针依次逼近
2. 数字来说，可以运用除法以及取余数的方法，研究构造一个新的数字

## 解答

````java
import org.junit.Test;
public class LeetCode9 {

    @Test
    public void test() {
        System.out.println(isPalindrome_1(121));
        System.out.println(isPalindrome_2(121));
    }

    // 很普遍的思路 将数字搞为字符串，前后指针依次比较即可
    public boolean isPalindrome_1(int x) {
        String s = x + "";
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // 不用字符串的方式，就用普通数学的方式
    // 假设数字121
    // 1. 121 % 10 = 1 121 / 10 = 12,num = 0*10+1=1
    // 2. 12 % 19 = 2,12 / 10 = 1,num = num*10+2=12
    // 3. 1 % 10 = 1, 1 / 10 = 0,num = 12*10+1=121
    public boolean isPalindrome_2(int x) {
        if(x < 0) return false;
        int num = 0,originNum = x;
        while (x != 0){
            int yu = x % 10;
            num = num * 10 + yu;
            x = x / 10;
        }
        return num == originNum;
    }
}


````









