package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by songbing
 * Created time 2019/5/16 下午9:19
 */
public abstract class LeetCode9 extends LeetCoding{

    // 字符串容易  前后指针 依次逼近
    // Time: O(m), Space: O(1)

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     示例 1:
     输入: 121
     输出: true
     示例 2:
     输入: -121
     输出: false
     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3:
     输入: 10
     输出: false
     解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    @Override
    public boolean isPalindrome(int x) {
        // 将数字搞为字符串
        String s = String.valueOf(x);
        int i = 0,j = s.length()-1;
        for( ; i<=j; ){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }


    // 不用字符串 就用整数【这种题目 可以用 / % 来做】  123
    public boolean solution2(int x){
        int y = 0;
        int temp = x;
        while (temp != 0){
            int num = temp % 10;
            y = y * 10 + num;
            temp = temp / 10;
        }
        return x == y;
    }
}
