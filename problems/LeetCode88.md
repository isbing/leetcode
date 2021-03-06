---
title: LeetCode88-合并两个有序数组
date: 2020-03-08
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。

你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:

nums1 = [1,2,3,0,0,0], m = 3

nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

## 分析
### 解法1
1 3 9 11 0 0 0

2 13

很常规的思路，定义一个新数组，依次比较nums1和nums2中的每个元素，谁小谁就进入新数组中，谁小谁移动

这样时间为o(m+n) 空间也为o(m+n)

### 解法二
如果不定义新数组的话，直接用nums1来做 将两个指针都设置到数组中的最后面，并且插入位置 也从最后面来

谁大就移动谁

例如 

nums1 = [1,3,9,11,0,0,0], m = 4

nums2 = [2,13],       n = 2

1. 首先i指向m-1处，j指向n-1处，i，j分别指向数组中的最后面
2. 插入初始位置为 m+n-1.
3. 首先11<13,那么将nums[m+n-1] = nums2[j]，j--。直到i,j<0，再将多余出来的 依次赋值完毕

时间0(M+N) 空间O(1)。 M+N因为 最糟糕的情况就是每个数据都依次塞进去。


## 总结
1. 直接看代码上的注释

## 解答

````java
import org.junit.Test;
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



````









