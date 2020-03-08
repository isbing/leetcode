package com.isbing.leetcode.coding;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by songbing
 * Created time 2020/3/8 下午6:15
 */
public class LeetCode88 {

    @Test
    public void test(){
        int[] nums1 = {1,3,9,11,0,0,0};
        int[] nums2 = {2,13};
//      System.out.println(Arrays.toString(merge_1(nums1,4,nums2,2)));

        merge_2(nums1,4,nums2,2);
        System.out.println(Arrays.toString(nums1));

    }

    // 很自然的一个思路 就是构建一个新数组 nums3[m+n]，最后赋值给nums1
    // 同时遍历nums1和nums2数组，谁小的就将值设置到nums3中，最后谁有多的 一并设置过去
    // 时间为o(m+n) 空间为o(m+n)
    public int[] merge_1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n){
            // 这个题目一定要有这个 这个题目其实nums1后面搞这么多0 是不应该参与运算的
            if(i < m && nums1[i] <= nums2[j]){
                nums3[k++] = nums1[i];
                i++;
            }else{
                nums3[k++] = nums2[j];
                j++;
            }
        }
        while (i < m) nums3[k++] = nums1[i++];
        while (j < n) nums3[k++] = nums2[j++];
        return nums3;
    }

    // nums1 = [1,3,9,11,0,0,0], m = 4  nums2 = [2,13], n = 2
    // 我们从两个数组的最后元素入手，定义nums1插入初始位置为 m+n-1，谁大谁就插入进去
    // 时间为o(m+n) 空间为o(1)
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i = m-1, j = n-1;
        while (i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i];
                i--;
            }else{
                nums1[index--] = nums2[j];
                j--;
            }
        }
        // 看谁有剩余
        while (i >= 0) nums1[index--] = nums1[i--];
        while (j >= 0) nums1[index--] = nums2[j--];
    }

}
