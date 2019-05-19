package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by songbing
 * Created time 2019/5/18 上午10:14
 */
public abstract class LeetCode53 extends LeetCoding{

    // 思路一：暴力法 两层for循环。穷举所有的连续子序列 并求和进行对比。最后取和最大的
    // 两层for循环 O(N方)。时间复杂度至少O(N方)

    // 思路二： Time: O(n), Space: O(1)
    // 2 -8 3 -2 4 -10 2 3 4 5 6
    // 2-8 = -6 只要是负数 就对子序列的和 没有任何贡献 还不如从 3 重新出发。3-2=1 1<max max不变
    // 1+4=5 5>max max变跟为5.5-10 = -5 负数 就舍弃

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     示例:
     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    @Override
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            if(sum <= 0){
                // 一连串的和为0或者负数 说明对当前子序列没啥正向影响 重新从下一个数字开始
                sum = nums[i];
            }else{ // 有正向的影响 就相加
                sum = sum + nums[i];
            }
            // 每一次 index都要与max比较一下 随时替换最大值
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
