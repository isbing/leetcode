package com.isbing.leetcode.coding;

import org.junit.Test;

/**
 * Created by songbing
 * Created time 2020/3/8 上午9:55
 */
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
