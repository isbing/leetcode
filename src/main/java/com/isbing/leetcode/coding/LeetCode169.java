package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

import java.util.*;

/**
 * Created by songbing
 * Created time 2019/5/19 上午10:24
 */
public abstract class LeetCode169 extends LeetCoding{

    // 思路一：hash表 存每个数字出现的 次数。
    // Time: O(n), Space: O(n)


    // 思路二：空间复杂度可以优化
    // Time: O(n), Space: O(1)
    // 摩尔投票算法 与 连续子序列和的思路一样 进行消除
    // 3 2 3 3
    // 首先当前值为3 出现次数为1.
    // 下次循环 当前值为2 2!=3 出现次数1-1=0 当为0之后，
    // 为0之后 就可以重置 当前值为3 出现次数为1
    // 下次循环 当前值为3 相同就+1.。最后返回的就是 当前值

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     你可以假设数组是非空的，并且给定的数组总是存在众数。
     示例 1:
     输入: [3,2,3]
     输出: 3
     示例 2:
     输入: [2,2,1,1,1,2,2]
     输出: 2
     */
    @Override
    public int majorityElement(int[] nums) {
        return solution2(nums);
    }

    // 优化
    private int solution2(int[] nums) {
        int currentNum = nums[0];
        int currentCount = 1;
        for(int i =1; i<nums.length; i++){
            if(currentCount <= 0){
                // 只要currentCount为0 就重置
                currentNum = nums[i];
                currentCount = 1;
            }else{
                if(currentNum == nums[i])
                    currentCount++;
                else
                    currentCount--;
            }
        }
        return currentNum;
    }

    // 这种暴力的解法 还得换一种思路
    // 并不是直接用map记录 每个数以及它出现的次数。这样下面只能把所有的value取出来。
    // value排好序之后 取出最大的value值。然后遍历map。当value=maxValue时，就return key
    private int solution1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        Object[] array = map.values().toArray();
        Arrays.sort(array);
        Object max = array[array.length-1];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : entries){
            if(entry.getValue() == max)
                return entry.getKey();
        }
        return 0;
    }

    // 不能一开始就保留所有的数据在map 【遍历的时候 就比较 才是最常见的思路】
    private static int solution3(int[] nums) {
        int maxCount = 0;
        int maxKey = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer integer = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],integer);
            if(integer > maxCount){
                maxCount = integer;
                maxKey = nums[i];
            }
        }
        return maxKey;
    }
}
