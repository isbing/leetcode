package com.isbing.leetcode;

import com.isbing.leetcode.bean.ListNode;
import com.isbing.leetcode.bean.TreeNode;

import java.util.List;

/**
 * Created by song bing
 * Created time 2019/5/14 17:26
 */
public abstract class LeetCoding {
	public abstract boolean isPalindrome(String s);//125
	public abstract int[] twoSum(int[] nums, int target);//1
	public abstract int[] twoSumV2(int[] numbers, int target);//167
	public abstract boolean isSymmetric(TreeNode root);//101
	public abstract int singleNumber(int[] nums);//136  单身数字
	public abstract boolean searchMatrix(int[][] matrix, int target);//240 矩阵中找数
	public abstract boolean isSameTree(TreeNode p, TreeNode q);//100 相同二叉树
	public abstract ListNode reverseList(ListNode head);//206 反转链表
	public abstract List<List<Integer>> permute(int[] nums);//46 不相同数字全排列 代码中包含去重操作
	public abstract boolean isPalindrome(int x);//9 回文数
	public abstract boolean isPalindrome(ListNode head);//234 回文链表


}
