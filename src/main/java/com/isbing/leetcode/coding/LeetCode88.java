package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;

/**
 * Created by songbing
 * Created time 2019/5/18 上午9:32
 */
public abstract class LeetCode88 extends LeetCoding{

    // 2 5 7
    // 1 4
    // 思路一：如果i j 分别指向两个数组的第一位。1 < 2 就需要把第一个数组
    // 中的所有数据向右移动一位，然后将1 插入 此时j++,再比较4与第一个数组的关系 看需要把它插入哪里

    // 思路二：  Time: O(m+n), Space: O(1)  将两个数组 都过了一遍
    // 从两个数组的最后一个元素想办法为ij。初始化插入位置为 m+n-1=k 代表ij最大的一个元素插入的位置
    // 首先 a[] b[]
    // 4<7 将a[k] = 7 然后7指针向左移位。。这样移动的位数就少了。

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     说明:
     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     示例:
     输入:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3
     输出: [1,2,2,3,5,6]
     */
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        //int i = nums1.length-1;// 错误写法 i 不能用数组长度
        int i = m-1;
        int j = nums2.length-1;
        while (i >= 0 && j >= 0){
            // 两数组 同时有指针的时候
            if(nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else{
                nums1[k--] = nums1[i--];
            }
        }
        // 第一个数组有剩余 都没啥问题 就怕第二个数组 剩余
        // 5 7
        // 1 2 3  ->     5 7
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }

    }
}
